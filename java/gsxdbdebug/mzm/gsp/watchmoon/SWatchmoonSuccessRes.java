/*    */ package mzm.gsp.watchmoon;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SWatchmoonSuccessRes
/*    */   extends __SWatchmoonSuccessRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12600833;
/*    */   public long partnerroleid;
/*    */   public String partnername;
/*    */   public int activitycount;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12600833;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SWatchmoonSuccessRes()
/*    */   {
/* 35 */     this.partnername = "";
/*    */   }
/*    */   
/*    */   public SWatchmoonSuccessRes(long _partnerroleid_, String _partnername_, int _activitycount_) {
/* 39 */     this.partnerroleid = _partnerroleid_;
/* 40 */     this.partnername = _partnername_;
/* 41 */     this.activitycount = _activitycount_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.partnerroleid);
/* 50 */     _os_.marshal(this.partnername, "UTF-16LE");
/* 51 */     _os_.marshal(this.activitycount);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.partnerroleid = _os_.unmarshal_long();
/* 57 */     this.partnername = _os_.unmarshal_String("UTF-16LE");
/* 58 */     this.activitycount = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SWatchmoonSuccessRes)) {
/* 68 */       SWatchmoonSuccessRes _o_ = (SWatchmoonSuccessRes)_o1_;
/* 69 */       if (this.partnerroleid != _o_.partnerroleid) return false;
/* 70 */       if (!this.partnername.equals(_o_.partnername)) return false;
/* 71 */       if (this.activitycount != _o_.activitycount) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += (int)this.partnerroleid;
/* 80 */     _h_ += this.partnername.hashCode();
/* 81 */     _h_ += this.activitycount;
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append(this.partnerroleid).append(",");
/* 89 */     _sb_.append("T").append(this.partnername.length()).append(",");
/* 90 */     _sb_.append(this.activitycount).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\watchmoon\SWatchmoonSuccessRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */