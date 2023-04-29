/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*    */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*    */ import mzm.gsp.crossbattle.own.PCGetRoundRobinRoundInfoInCrossBattle;
/*    */ 
/*    */ public class CGetRoundRobinRoundInfoInCrossBattleReq
/*    */   extends __CGetRoundRobinRoundInfoInCrossBattleReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12616966;
/*    */   public int activity_cfg_id;
/*    */   public int index;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     if ((roleid < 0L) || (!SCrossBattleOwnCfg.getAll().containsKey(Integer.valueOf(this.activity_cfg_id))))
/* 22 */       return;
/* 23 */     CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activity_cfg_id), new PCGetRoundRobinRoundInfoInCrossBattle(roleid, this.activity_cfg_id, this.index));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12616966;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CGetRoundRobinRoundInfoInCrossBattleReq() {}
/*    */   
/*    */ 
/*    */   public CGetRoundRobinRoundInfoInCrossBattleReq(int _activity_cfg_id_, int _index_)
/*    */   {
/* 42 */     this.activity_cfg_id = _activity_cfg_id_;
/* 43 */     this.index = _index_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.activity_cfg_id);
/* 52 */     _os_.marshal(this.index);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 58 */     this.index = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof CGetRoundRobinRoundInfoInCrossBattleReq)) {
/* 68 */       CGetRoundRobinRoundInfoInCrossBattleReq _o_ = (CGetRoundRobinRoundInfoInCrossBattleReq)_o1_;
/* 69 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/* 70 */       if (this.index != _o_.index) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.activity_cfg_id;
/* 79 */     _h_ += this.index;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.activity_cfg_id).append(",");
/* 87 */     _sb_.append(this.index).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGetRoundRobinRoundInfoInCrossBattleReq _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.index - _o_.index;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\CGetRoundRobinRoundInfoInCrossBattleReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */