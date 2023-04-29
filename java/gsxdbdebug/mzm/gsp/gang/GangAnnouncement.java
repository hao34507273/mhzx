/*    */ package mzm.gsp.gang;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class GangAnnouncement
/*    */   implements Marshal
/*    */ {
/*    */   public String announcement;
/*    */   public String publisher;
/*    */   public long publishtime;
/*    */   
/*    */   public GangAnnouncement()
/*    */   {
/* 16 */     this.announcement = "";
/* 17 */     this.publisher = "";
/*    */   }
/*    */   
/*    */   public GangAnnouncement(String _announcement_, String _publisher_, long _publishtime_) {
/* 21 */     this.announcement = _announcement_;
/* 22 */     this.publisher = _publisher_;
/* 23 */     this.publishtime = _publishtime_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 31 */     _os_.marshal(this.announcement, "UTF-16LE");
/* 32 */     _os_.marshal(this.publisher, "UTF-16LE");
/* 33 */     _os_.marshal(this.publishtime);
/* 34 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 38 */     this.announcement = _os_.unmarshal_String("UTF-16LE");
/* 39 */     this.publisher = _os_.unmarshal_String("UTF-16LE");
/* 40 */     this.publishtime = _os_.unmarshal_long();
/* 41 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 45 */     if (_o1_ == this) return true;
/* 46 */     if ((_o1_ instanceof GangAnnouncement)) {
/* 47 */       GangAnnouncement _o_ = (GangAnnouncement)_o1_;
/* 48 */       if (!this.announcement.equals(_o_.announcement)) return false;
/* 49 */       if (!this.publisher.equals(_o_.publisher)) return false;
/* 50 */       if (this.publishtime != _o_.publishtime) return false;
/* 51 */       return true;
/*    */     }
/* 53 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 57 */     int _h_ = 0;
/* 58 */     _h_ += this.announcement.hashCode();
/* 59 */     _h_ += this.publisher.hashCode();
/* 60 */     _h_ += (int)this.publishtime;
/* 61 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 65 */     StringBuilder _sb_ = new StringBuilder();
/* 66 */     _sb_.append("(");
/* 67 */     _sb_.append("T").append(this.announcement.length()).append(",");
/* 68 */     _sb_.append("T").append(this.publisher.length()).append(",");
/* 69 */     _sb_.append(this.publishtime).append(",");
/* 70 */     _sb_.append(")");
/* 71 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\GangAnnouncement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */