/*    */ package mzm.gsp.backgameactivity;
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
/*    */ public class SUseManekiTokenRsp
/*    */   extends __SUseManekiTokenRsp__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12620567;
/*    */   public int activityid;
/*    */   public int manekitokencfgid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12620567;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SUseManekiTokenRsp() {}
/*    */   
/*    */ 
/*    */   public SUseManekiTokenRsp(int _activityid_, int _manekitokencfgid_)
/*    */   {
/* 35 */     this.activityid = _activityid_;
/* 36 */     this.manekitokencfgid = _manekitokencfgid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.activityid);
/* 45 */     _os_.marshal(this.manekitokencfgid);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.activityid = _os_.unmarshal_int();
/* 51 */     this.manekitokencfgid = _os_.unmarshal_int();
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SUseManekiTokenRsp)) {
/* 61 */       SUseManekiTokenRsp _o_ = (SUseManekiTokenRsp)_o1_;
/* 62 */       if (this.activityid != _o_.activityid) return false;
/* 63 */       if (this.manekitokencfgid != _o_.manekitokencfgid) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += this.activityid;
/* 72 */     _h_ += this.manekitokencfgid;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.activityid).append(",");
/* 80 */     _sb_.append(this.manekitokencfgid).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SUseManekiTokenRsp _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = this.activityid - _o_.activityid;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     _c_ = this.manekitokencfgid - _o_.manekitokencfgid;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\backgameactivity\SUseManekiTokenRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */