/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*    */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*    */ import mzm.gsp.crossbattle.own.PCEnterRoundRobinMap;
/*    */ 
/*    */ 
/*    */ public class CEnterRoundRobinMapReq
/*    */   extends __CEnterRoundRobinMapReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12616987;
/*    */   public int activity_cfg_id;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     if ((roleid < 0L) || (!SCrossBattleOwnCfg.getAll().containsKey(Integer.valueOf(this.activity_cfg_id))))
/*    */     {
/* 23 */       return;
/*    */     }
/* 25 */     CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activity_cfg_id), new PCEnterRoundRobinMap(roleid, this.activity_cfg_id));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 34 */     return 12616987;
/*    */   }
/*    */   
/*    */ 
/*    */   public CEnterRoundRobinMapReq() {}
/*    */   
/*    */ 
/*    */   public CEnterRoundRobinMapReq(int _activity_cfg_id_)
/*    */   {
/* 43 */     this.activity_cfg_id = _activity_cfg_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.activity_cfg_id);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof CEnterRoundRobinMapReq)) {
/* 66 */       CEnterRoundRobinMapReq _o_ = (CEnterRoundRobinMapReq)_o1_;
/* 67 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.activity_cfg_id;
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.activity_cfg_id).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CEnterRoundRobinMapReq _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\CEnterRoundRobinMapReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */