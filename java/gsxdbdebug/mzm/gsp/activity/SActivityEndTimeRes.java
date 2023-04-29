/*    */ package mzm.gsp.activity;
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
/*    */ 
/*    */ public class SActivityEndTimeRes
/*    */   extends __SActivityEndTimeRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12587556;
/*    */   public int activityid;
/*    */   public int endtime;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12587556;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SActivityEndTimeRes() {}
/*    */   
/*    */ 
/*    */   public SActivityEndTimeRes(int _activityid_, int _endtime_)
/*    */   {
/* 37 */     this.activityid = _activityid_;
/* 38 */     this.endtime = _endtime_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.activityid);
/* 47 */     _os_.marshal(this.endtime);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.activityid = _os_.unmarshal_int();
/* 53 */     this.endtime = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SActivityEndTimeRes)) {
/* 63 */       SActivityEndTimeRes _o_ = (SActivityEndTimeRes)_o1_;
/* 64 */       if (this.activityid != _o_.activityid) return false;
/* 65 */       if (this.endtime != _o_.endtime) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.activityid;
/* 74 */     _h_ += this.endtime;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.activityid).append(",");
/* 82 */     _sb_.append(this.endtime).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SActivityEndTimeRes _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.activityid - _o_.activityid;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.endtime - _o_.endtime;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\SActivityEndTimeRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */