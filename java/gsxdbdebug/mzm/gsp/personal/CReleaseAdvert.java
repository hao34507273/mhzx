/*    */ package mzm.gsp.personal;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.personal.main.PCReleaseAdvert;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CReleaseAdvert
/*    */   extends __CReleaseAdvert__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12603659;
/*    */   public SimpleAdvertInfo advert;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     if (roleId < 1L) {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PCReleaseAdvert(roleId, this.advert));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12603659;
/*    */   }
/*    */   
/*    */ 
/*    */   public CReleaseAdvert()
/*    */   {
/* 38 */     this.advert = new SimpleAdvertInfo();
/*    */   }
/*    */   
/*    */   public CReleaseAdvert(SimpleAdvertInfo _advert_) {
/* 42 */     this.advert = _advert_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     if (!this.advert._validator_()) return false;
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.advert);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.advert.unmarshal(_os_);
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof CReleaseAdvert)) {
/* 66 */       CReleaseAdvert _o_ = (CReleaseAdvert)_o1_;
/* 67 */       if (!this.advert.equals(_o_.advert)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.advert.hashCode();
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.advert).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\CReleaseAdvert.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */