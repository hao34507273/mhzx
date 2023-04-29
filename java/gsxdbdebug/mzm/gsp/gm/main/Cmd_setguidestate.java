/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.guide.confbean.SGuide;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.GuideState;
/*    */ import xbean.Pod;
/*    */ import xtable.Name2roleid;
/*    */ import xtable.Role2guidestate;
/*    */ 
/*    */ public class Cmd_setguidestate extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private int guideid;
/*    */   private int state;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 23 */     this.roleId = this.m_gmRole.getRoleid();
/*    */     
/* 25 */     if (this.m_arguments == null) {
/* 26 */       return false;
/*    */     }
/* 28 */     int index = 0;
/*    */     
/* 30 */     if (index >= this.m_arguments.size()) {
/* 31 */       return false;
/*    */     }
/* 33 */     Long targetId = null;
/* 34 */     targetId = Name2roleid.select((String)this.m_arguments.get(index));
/*    */     
/* 36 */     if (targetId != null)
/*    */     {
/* 38 */       this.roleId = targetId.longValue();
/* 39 */       index++;
/*    */     }
/*    */     
/* 42 */     if (index >= this.m_arguments.size()) {
/* 43 */       return false;
/*    */     }
/* 45 */     Integer I_guideid = parseInt((String)this.m_arguments.get(index++));
/* 46 */     if (I_guideid == null) {
/* 47 */       return false;
/*    */     }
/* 49 */     this.guideid = I_guideid.intValue();
/*    */     
/* 51 */     if (index >= this.m_arguments.size()) {
/* 52 */       return false;
/*    */     }
/* 54 */     Integer I_state = parseInt((String)this.m_arguments.get(index++));
/* 55 */     if (I_state == null) {
/* 56 */       return false;
/*    */     }
/* 58 */     this.state = I_state.intValue();
/*    */     
/* 60 */     if (index != this.m_arguments.size()) {
/* 61 */       return false;
/*    */     }
/* 63 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 72 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 78 */     new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception
/*    */       {
/* 82 */         GuideState guideState = Role2guidestate.get(Long.valueOf(Cmd_setguidestate.this.roleId));
/* 83 */         if (guideState == null) {
/* 84 */           guideState = Pod.newGuideState();
/* 85 */           Role2guidestate.insert(Long.valueOf(Cmd_setguidestate.this.roleId), guideState);
/*    */         }
/*    */         
/* 88 */         if (Cmd_setguidestate.this.guideid == 0) {
/*    */           Iterator i$;
/* 90 */           if (Cmd_setguidestate.this.state == 1) {
/* 91 */             for (i$ = SGuide.getAll().keySet().iterator(); i$.hasNext();) { int id = ((Integer)i$.next()).intValue();
/* 92 */               guideState.getGuideid2state().put(Integer.valueOf(id), Integer.valueOf(1));
/*    */             }
/*    */           }
/*    */           else {
/* 96 */             guideState.getGuideid2state().clear();
/* 97 */             guideState.getGuideid2param().clear();
/*    */           }
/*    */         }
/*    */         else
/*    */         {
/* :2 */           SGuide guide = SGuide.get(Cmd_setguidestate.this.guideid);
/* :3 */           if (guide == null) {
/* :4 */             return false;
/*    */           }
/*    */           
/* :7 */           if (Cmd_setguidestate.this.state == 1)
/*    */           {
/* :9 */             guideState.getGuideid2state().put(Integer.valueOf(Cmd_setguidestate.this.guideid), Integer.valueOf(1));
/*    */           }
/*    */           else
/*    */           {
/* ;3 */             guideState.getGuideid2state().remove(guide);
/* ;4 */             guideState.getGuideid2param().remove(guide);
/*    */           }
/*    */         }
/*    */         
/* ;8 */         return true;
/*    */       }
/*    */     }.execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_setguidestate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */