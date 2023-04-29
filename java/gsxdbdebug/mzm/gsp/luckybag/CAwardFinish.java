/*    */ package mzm.gsp.luckybag;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.luckybag.main.PCAwardFinish;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CAwardFinish
/*    */   extends __CAwardFinish__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12607493;
/*    */   public int map_item_cfgid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L)
/*    */     {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PCAwardFinish(roleId, this.map_item_cfgid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12607493;
/*    */   }
/*    */   
/*    */ 
/*    */   public CAwardFinish() {}
/*    */   
/*    */ 
/*    */   public CAwardFinish(int _map_item_cfgid_)
/*    */   {
/* 41 */     this.map_item_cfgid = _map_item_cfgid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.map_item_cfgid);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.map_item_cfgid = _os_.unmarshal_int();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof CAwardFinish)) {
/* 64 */       CAwardFinish _o_ = (CAwardFinish)_o1_;
/* 65 */       if (this.map_item_cfgid != _o_.map_item_cfgid) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.map_item_cfgid;
/* 74 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 78 */     StringBuilder _sb_ = new StringBuilder();
/* 79 */     _sb_.append("(");
/* 80 */     _sb_.append(this.map_item_cfgid).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CAwardFinish _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = this.map_item_cfgid - _o_.map_item_cfgid;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckybag\CAwardFinish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */