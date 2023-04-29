/*    */ package mzm.gsp.firework;
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
/*    */ public class SSynFireworkShowStage
/*    */   extends __SSynFireworkShowStage__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12625157;
/*    */   public int activityid;
/*    */   public FireWorkStageInfo stageinfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12625157;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSynFireworkShowStage()
/*    */   {
/* 34 */     this.stageinfo = new FireWorkStageInfo();
/*    */   }
/*    */   
/*    */   public SSynFireworkShowStage(int _activityid_, FireWorkStageInfo _stageinfo_) {
/* 38 */     this.activityid = _activityid_;
/* 39 */     this.stageinfo = _stageinfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.stageinfo._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.activityid);
/* 49 */     _os_.marshal(this.stageinfo);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.activityid = _os_.unmarshal_int();
/* 55 */     this.stageinfo.unmarshal(_os_);
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SSynFireworkShowStage)) {
/* 65 */       SSynFireworkShowStage _o_ = (SSynFireworkShowStage)_o1_;
/* 66 */       if (this.activityid != _o_.activityid) return false;
/* 67 */       if (!this.stageinfo.equals(_o_.stageinfo)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.activityid;
/* 76 */     _h_ += this.stageinfo.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.activityid).append(",");
/* 84 */     _sb_.append(this.stageinfo).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSynFireworkShowStage _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.activityid - _o_.activityid;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.stageinfo.compareTo(_o_.stageinfo);
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\firework\SSynFireworkShowStage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */