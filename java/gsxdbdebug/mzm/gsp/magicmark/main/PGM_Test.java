/*    */ package mzm.gsp.magicmark.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_Test extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PGM_Test(long roleid)
/*    */   {
/* 13 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 18 */     testEquipMagicMarkReq();
/* 19 */     testExtendMagicMarkTimeReq();
/* 20 */     testSelectProp();
/* 21 */     testUnSelectProp();
/* 22 */     testUnEquipMagicMarkReq();
/* 23 */     testUnLockMagicMarkReq();
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   private void testUnLockMagicMarkReq() {
/* 28 */     List<Integer> items = new ArrayList();
/* 29 */     items.add(Integer.valueOf(221000001));
/* 30 */     new PCUnLockMagicMarkReq(this.roleid, items).execute();
/* 31 */     items = new ArrayList();
/* 32 */     items.add(Integer.valueOf(221000001));
/* 33 */     items.add(Integer.valueOf(215600000));
/* 34 */     new PCUnLockMagicMarkReq(this.roleid, items).execute();
/* 35 */     items = new ArrayList();
/* 36 */     items.add(Integer.valueOf(215600005));
/* 37 */     items.add(Integer.valueOf(215600000));
/* 38 */     new PCUnLockMagicMarkReq(this.roleid, items).execute();
/* 39 */     items = new ArrayList();
/* 40 */     items.add(Integer.valueOf(215600001));
/* 41 */     items.add(Integer.valueOf(215600000));
/* 42 */     new PCUnLockMagicMarkReq(this.roleid, items).execute();
/* 43 */     items = new ArrayList();
/* 44 */     items.add(Integer.valueOf(215600001));
/* 45 */     items.add(Integer.valueOf(215600000));
/* 46 */     items.add(Integer.valueOf(215600002));
/* 47 */     new PCUnLockMagicMarkReq(this.roleid, items).execute();
/*    */   }
/*    */   
/*    */   private void testUnEquipMagicMarkReq() {
/* 51 */     new PCUnEuquipMagicMarkReq(this.roleid, 0).execute();
/* 52 */     new PCUnEuquipMagicMarkReq(this.roleid, -1).execute();
/* 53 */     new PCUnEuquipMagicMarkReq(this.roleid, 1).execute();
/*    */   }
/*    */   
/*    */   private void testUnSelectProp() {
/* 57 */     new PCMagicMarkUnSelectPropReq(this.roleid, 0).execute();
/* 58 */     new PCMagicMarkUnSelectPropReq(this.roleid, -1).execute();
/* 59 */     new PCMagicMarkUnSelectPropReq(this.roleid, 1).execute();
/*    */   }
/*    */   
/*    */   private void testSelectProp() {
/* 63 */     new PCMagicMarkSelectPropReq(this.roleid, 0).execute();
/* 64 */     new PCMagicMarkSelectPropReq(this.roleid, -1).execute();
/* 65 */     new PCMagicMarkSelectPropReq(this.roleid, 1).execute();
/*    */   }
/*    */   
/*    */   private void testExtendMagicMarkTimeReq() {
/* 69 */     List<Integer> items = new ArrayList();
/* 70 */     items.add(Integer.valueOf(221000001));
/* 71 */     new PCExtendMagicMarkTimeReq(this.roleid, items).execute();
/* 72 */     items = new ArrayList();
/* 73 */     items.add(Integer.valueOf(221000001));
/* 74 */     items.add(Integer.valueOf(215600000));
/* 75 */     new PCExtendMagicMarkTimeReq(this.roleid, items).execute();
/* 76 */     items = new ArrayList();
/* 77 */     items.add(Integer.valueOf(215600005));
/* 78 */     items.add(Integer.valueOf(215600000));
/* 79 */     new PCExtendMagicMarkTimeReq(this.roleid, items).execute();
/* 80 */     items = new ArrayList();
/* 81 */     items.add(Integer.valueOf(215600001));
/* 82 */     items.add(Integer.valueOf(215600000));
/* 83 */     new PCExtendMagicMarkTimeReq(this.roleid, items).execute();
/* 84 */     items = new ArrayList();
/* 85 */     items.add(Integer.valueOf(215600001));
/* 86 */     items.add(Integer.valueOf(215600000));
/* 87 */     items.add(Integer.valueOf(215600002));
/* 88 */     new PCExtendMagicMarkTimeReq(this.roleid, items).execute();
/*    */   }
/*    */   
/*    */   void testEquipMagicMarkReq() {
/* 92 */     new PCEquipMagicMarkReq(this.roleid, 0).execute();
/* 93 */     new PCEquipMagicMarkReq(this.roleid, -1).execute();
/* 94 */     new PCEquipMagicMarkReq(this.roleid, 1).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\magicmark\main\PGM_Test.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */