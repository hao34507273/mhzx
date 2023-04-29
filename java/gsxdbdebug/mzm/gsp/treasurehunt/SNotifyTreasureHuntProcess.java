/*    */ package mzm.gsp.treasurehunt;
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
/*    */ public class SNotifyTreasureHuntProcess
/*    */   extends __SNotifyTreasureHuntProcess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12633095;
/*    */   public int process;
/*    */   public int total;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12633095;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SNotifyTreasureHuntProcess() {}
/*    */   
/*    */ 
/*    */   public SNotifyTreasureHuntProcess(int _process_, int _total_)
/*    */   {
/* 37 */     this.process = _process_;
/* 38 */     this.total = _total_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.process);
/* 47 */     _os_.marshal(this.total);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.process = _os_.unmarshal_int();
/* 53 */     this.total = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SNotifyTreasureHuntProcess)) {
/* 63 */       SNotifyTreasureHuntProcess _o_ = (SNotifyTreasureHuntProcess)_o1_;
/* 64 */       if (this.process != _o_.process) return false;
/* 65 */       if (this.total != _o_.total) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.process;
/* 74 */     _h_ += this.total;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.process).append(",");
/* 82 */     _sb_.append(this.total).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SNotifyTreasureHuntProcess _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.process - _o_.process;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.total - _o_.total;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\treasurehunt\SNotifyTreasureHuntProcess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */