package com.learning.test_drools;

import com.sun.tools.javac.util.List;
import org.drools.core.event.DebugAgendaEventListener;
import org.drools.core.event.DebugRuleRuntimeEventListener;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.definition.KiePackage;
import org.kie.api.logger.KieRuntimeLogger;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class TestRules {

  static KieBase kbase;
  static KieSession ksession;
  static KieRuntimeLogger klogger;

  @BeforeClass
  public static void setupKsession() {
    try {
      // load up the knowledge base and create session
      ksession = readKnowledgeBase();
      System.out.println("setupKsession() ksession  = " + ksession);
      klogger = KieServices.Factory.get().getLoggers().newFileLogger(ksession, "src/test/rule");
      kbase = ksession.getKieBase();
      int nRules = 0;
      Collection<KiePackage> packages = kbase.getKiePackages();
      for (KiePackage pack : packages) {
        nRules += pack.getRules().size();
        System.out.println(pack.getRules().toString());
      }
      System.out.println("total rules " + nRules);

//      ksession.addEventListener(new DebugRuleRuntimeEventListener());
//      ksession.addEventListener(new DebugAgendaEventListener());

    } catch (Throwable t) {
      t.printStackTrace();
    }
  }

  private static KieSession readKnowledgeBase() throws Exception {
    KieServices ks = KieServices.Factory.get();
    KieContainer kContainer = ks.getKieClasspathContainer();
    KieSession kSession = kContainer.newKieSession();
    return kSession;
  }

  @AfterClass
  public static void closeKsession() {
    try {
      // closing resources
      klogger.close();
      ksession.dispose();
    } catch (Throwable t) {
      t.printStackTrace();
    }
  }

  @Test
  public void test1() {
    // now create some test data
    Fact1 fact1 = new Fact1();
    fact1.setIden(102);
    fact1.setQuantifier1(1001);
    Fact2 f2 = new Fact2();
    f2.setIden("102");
    f2.setQuantifier1(1010);
    f2.setSubFacts2(List.of("st1", "st2", "st3"));
    SubFact2 s1 = new SubFact2(10, "dds");
    SubFact2 s2 = new SubFact2(55, "sdfd");
    f2.setIntFacts(List.of(s1, s2));
    // insert objects into working memory
    ksession.getAgenda().getAgendaGroup("ag1").setFocus();
    FactHandle fh1 = ksession.insert(fact1);
    FactHandle fh2 = ksession.insert(f2);
    ksession.fireAllRules();
    ksession.delete(fh1);
    ksession.delete(fh2);
    ksession.getAgenda().getAgendaGroup("ag1").clear();
    assertEquals("Check description > 100", "both facts are mare than 100", fact1.getDescription());
  }

  @Test
  public void test2() {
    // now create some test data
    Fact1 fact1 = new Fact1();
    fact1.setIden(101);
    fact1.setQuantifier1(1001);
    Fact2 f2 = new Fact2();
    f2.setIden("101");
    f2.setQuantifier1(1010);
    f2.setSubFacts2(List.of("st11", "st2", "st3"));
    // insert objects into working memory
    ksession.getAgenda().getAgendaGroup("ag1").setFocus();
    FactHandle fh1 = ksession.insert(fact1);
    FactHandle fh2 = ksession.insert(f2);
    ksession.fireAllRules();
    ksession.delete(fh1);
    ksession.delete(fh2);
    ksession.getAgenda().getAgendaGroup("ag1").clear();
    assertEquals("Check special fact", "special fact", fact1.getDescription());
  }

  @Test
  public void test3() {
    ExlFact fact1 = new ExlFact();
    fact1.setQuan1(101);
    FactHandle fh1 = ksession.insert(fact1);
    ksession.fireAllRules();
    ksession.delete(fh1);
    assertEquals("> 10 scenario", 100, fact1.getRs1());
    System.out.println("completed excel fact : " + fact1.toString());
  }
}
