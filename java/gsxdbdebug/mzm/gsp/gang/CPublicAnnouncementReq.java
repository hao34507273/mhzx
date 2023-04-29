/*    */ package mzm.gsp.gang;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.gang.main.PPublishAnnouncementReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CPublicAnnouncementReq
/*    */   extends __CPublicAnnouncementReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12589888;
/*    */   public String announcement;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     new PPublishAnnouncementReq(this);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 27 */     return 12589888;
/*    */   }
/*    */   
/*    */ 
/*    */   public CPublicAnnouncementReq()
/*    */   {
/* 33 */     this.announcement = "";
/*    */   }
/*    */   
/*    */   public CPublicAnnouncementReq(String _announcement_) {
/* 37 */     this.announcement = _announcement_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.marshal(this.announcement, "UTF-16LE");
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.announcement = _os_.unmarshal_String("UTF-16LE");
/* 51 */     if (!_validator_()) {
/* 52 */       throw new VerifyError("validator failed");
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 58 */     if (_o1_ == this) return true;
/* 59 */     if ((_o1_ instanceof CPublicAnnouncementReq)) {
/* 60 */       CPublicAnnouncementReq _o_ = (CPublicAnnouncementReq)_o1_;
/* 61 */       if (!this.announcement.equals(_o_.announcement)) return false;
/* 62 */       return true;
/*    */     }
/* 64 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 68 */     int _h_ = 0;
/* 69 */     _h_ += this.announcement.hashCode();
/* 70 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 74 */     StringBuilder _sb_ = new StringBuilder();
/* 75 */     _sb_.append("(");
/* 76 */     _sb_.append("T").append(this.announcement.length()).append(",");
/* 77 */     _sb_.append(")");
/* 78 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\CPublicAnnouncementReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */