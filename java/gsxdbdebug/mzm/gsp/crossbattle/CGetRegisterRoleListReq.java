/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*    */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*    */ import mzm.gsp.crossbattle.own.PCGetRegisterRoleList;
/*    */ 
/*    */ public class CGetRegisterRoleListReq
/*    */   extends __CGetRegisterRoleListReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12617006;
/*    */   public int activity_cfg_id;
/*    */   public long corps_id;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     if ((roleid < 0L) || (!SCrossBattleOwnCfg.getAll().containsKey(Integer.valueOf(this.activity_cfg_id))))
/* 22 */       return;
/* 23 */     CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activity_cfg_id), new PCGetRegisterRoleList(roleid, this.activity_cfg_id, this.corps_id));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12617006;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CGetRegisterRoleListReq() {}
/*    */   
/*    */ 
/*    */   public CGetRegisterRoleListReq(int _activity_cfg_id_, long _corps_id_)
/*    */   {
/* 42 */     this.activity_cfg_id = _activity_cfg_id_;
/* 43 */     this.corps_id = _corps_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.activity_cfg_id);
/* 52 */     _os_.marshal(this.corps_id);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 58 */     this.corps_id = _os_.unmarshal_long();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof CGetRegisterRoleListReq)) {
/* 68 */       CGetRegisterRoleListReq _o_ = (CGetRegisterRoleListReq)_o1_;
/* 69 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/* 70 */       if (this.corps_id != _o_.corps_id) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.activity_cfg_id;
/* 79 */     _h_ += (int)this.corps_id;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.activity_cfg_id).append(",");
/* 87 */     _sb_.append(this.corps_id).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGetRegisterRoleListReq _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = Long.signum(this.corps_id - _o_.corps_id);
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\CGetRegisterRoleListReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */