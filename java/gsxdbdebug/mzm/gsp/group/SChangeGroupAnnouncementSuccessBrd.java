/*    */ package mzm.gsp.group;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SChangeGroupAnnouncementSuccessBrd
/*    */   extends __SChangeGroupAnnouncementSuccessBrd__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12605217;
/*    */   public long groupid;
/*    */   public Octets announcement;
/*    */   public long info_version;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12605217;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SChangeGroupAnnouncementSuccessBrd()
/*    */   {
/* 35 */     this.announcement = new Octets();
/*    */   }
/*    */   
/*    */   public SChangeGroupAnnouncementSuccessBrd(long _groupid_, Octets _announcement_, long _info_version_) {
/* 39 */     this.groupid = _groupid_;
/* 40 */     this.announcement = _announcement_;
/* 41 */     this.info_version = _info_version_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.groupid);
/* 50 */     _os_.marshal(this.announcement);
/* 51 */     _os_.marshal(this.info_version);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.groupid = _os_.unmarshal_long();
/* 57 */     this.announcement = _os_.unmarshal_Octets();
/* 58 */     this.info_version = _os_.unmarshal_long();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SChangeGroupAnnouncementSuccessBrd)) {
/* 68 */       SChangeGroupAnnouncementSuccessBrd _o_ = (SChangeGroupAnnouncementSuccessBrd)_o1_;
/* 69 */       if (this.groupid != _o_.groupid) return false;
/* 70 */       if (!this.announcement.equals(_o_.announcement)) return false;
/* 71 */       if (this.info_version != _o_.info_version) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += (int)this.groupid;
/* 80 */     _h_ += this.announcement.hashCode();
/* 81 */     _h_ += (int)this.info_version;
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append(this.groupid).append(",");
/* 89 */     _sb_.append("B").append(this.announcement.size()).append(",");
/* 90 */     _sb_.append(this.info_version).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\SChangeGroupAnnouncementSuccessBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */