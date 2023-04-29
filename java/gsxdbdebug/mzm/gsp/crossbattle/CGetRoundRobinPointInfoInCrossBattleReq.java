/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*    */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*    */ import mzm.gsp.crossbattle.own.PCGetRoundRobinPointInfoInCrossBattle;
/*    */ 
/*    */ 
/*    */ public class CGetRoundRobinPointInfoInCrossBattleReq
/*    */   extends __CGetRoundRobinPointInfoInCrossBattleReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12616963;
/*    */   public int activity_cfg_id;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     if ((roleid < 0L) || (!SCrossBattleOwnCfg.getAll().containsKey(Integer.valueOf(this.activity_cfg_id))))
/* 22 */       return;
/* 23 */     CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activity_cfg_id), new PCGetRoundRobinPointInfoInCrossBattle(roleid, this.activity_cfg_id));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12616963;
/*    */   }
/*    */   
/*    */ 
/*    */   public CGetRoundRobinPointInfoInCrossBattleReq() {}
/*    */   
/*    */ 
/*    */   public CGetRoundRobinPointInfoInCrossBattleReq(int _activity_cfg_id_)
/*    */   {
/* 41 */     this.activity_cfg_id = _activity_cfg_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.activity_cfg_id);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof CGetRoundRobinPointInfoInCrossBattleReq)) {
/* 64 */       CGetRoundRobinPointInfoInCrossBattleReq _o_ = (CGetRoundRobinPointInfoInCrossBattleReq)_o1_;
/* 65 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.activity_cfg_id;
/* 74 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 78 */     StringBuilder _sb_ = new StringBuilder();
/* 79 */     _sb_.append("(");
/* 80 */     _sb_.append(this.activity_cfg_id).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGetRoundRobinPointInfoInCrossBattleReq _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\CGetRoundRobinPointInfoInCrossBattleReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */