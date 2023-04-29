/*    */ package mzm.gsp.award;
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
/*    */ public class SSynSingleLostExpInfo
/*    */   extends __SSynSingleLostExpInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12583449;
/*    */   public int activityid;
/*    */   public LostExpInfo lostexpinfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12583449;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSynSingleLostExpInfo()
/*    */   {
/* 34 */     this.lostexpinfo = new LostExpInfo();
/*    */   }
/*    */   
/*    */   public SSynSingleLostExpInfo(int _activityid_, LostExpInfo _lostexpinfo_) {
/* 38 */     this.activityid = _activityid_;
/* 39 */     this.lostexpinfo = _lostexpinfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.lostexpinfo._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.activityid);
/* 49 */     _os_.marshal(this.lostexpinfo);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.activityid = _os_.unmarshal_int();
/* 55 */     this.lostexpinfo.unmarshal(_os_);
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SSynSingleLostExpInfo)) {
/* 65 */       SSynSingleLostExpInfo _o_ = (SSynSingleLostExpInfo)_o1_;
/* 66 */       if (this.activityid != _o_.activityid) return false;
/* 67 */       if (!this.lostexpinfo.equals(_o_.lostexpinfo)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.activityid;
/* 76 */     _h_ += this.lostexpinfo.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.activityid).append(",");
/* 84 */     _sb_.append(this.lostexpinfo).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSynSingleLostExpInfo _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.activityid - _o_.activityid;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.lostexpinfo.compareTo(_o_.lostexpinfo);
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\SSynSingleLostExpInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */