/*    */ package mzm.gsp.afk;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.afk.main.RCReply;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CReply
/*    */   extends __CReply__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12622338;
/*    */   public int afk_detect_cfg_id;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleid = Role.getRoleId(this);
/* 20 */     if (roleid < 0L)
/* 21 */       return;
/* 22 */     Role.addRoleRunnable(roleid, new RCReply(roleid, this.afk_detect_cfg_id));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 30 */     return 12622338;
/*    */   }
/*    */   
/*    */ 
/*    */   public CReply() {}
/*    */   
/*    */ 
/*    */   public CReply(int _afk_detect_cfg_id_)
/*    */   {
/* 39 */     this.afk_detect_cfg_id = _afk_detect_cfg_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.afk_detect_cfg_id);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.afk_detect_cfg_id = _os_.unmarshal_int();
/* 53 */     if (!_validator_()) {
/* 54 */       throw new VerifyError("validator failed");
/*    */     }
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 60 */     if (_o1_ == this) return true;
/* 61 */     if ((_o1_ instanceof CReply)) {
/* 62 */       CReply _o_ = (CReply)_o1_;
/* 63 */       if (this.afk_detect_cfg_id != _o_.afk_detect_cfg_id) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += this.afk_detect_cfg_id;
/* 72 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 76 */     StringBuilder _sb_ = new StringBuilder();
/* 77 */     _sb_.append("(");
/* 78 */     _sb_.append(this.afk_detect_cfg_id).append(",");
/* 79 */     _sb_.append(")");
/* 80 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CReply _o_) {
/* 84 */     if (_o_ == this) return 0;
/* 85 */     int _c_ = 0;
/* 86 */     _c_ = this.afk_detect_cfg_id - _o_.afk_detect_cfg_id;
/* 87 */     if (0 != _c_) return _c_;
/* 88 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\afk\CReply.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */