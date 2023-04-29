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
/*    */ public class SNotifyReduceTreasureHuntTime
/*    */   extends __SNotifyReduceTreasureHuntTime__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12633094;
/*    */   public int reduce_seconds;
/*    */   public int left_seconds;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12633094;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SNotifyReduceTreasureHuntTime() {}
/*    */   
/*    */ 
/*    */   public SNotifyReduceTreasureHuntTime(int _reduce_seconds_, int _left_seconds_)
/*    */   {
/* 37 */     this.reduce_seconds = _reduce_seconds_;
/* 38 */     this.left_seconds = _left_seconds_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.reduce_seconds);
/* 47 */     _os_.marshal(this.left_seconds);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.reduce_seconds = _os_.unmarshal_int();
/* 53 */     this.left_seconds = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SNotifyReduceTreasureHuntTime)) {
/* 63 */       SNotifyReduceTreasureHuntTime _o_ = (SNotifyReduceTreasureHuntTime)_o1_;
/* 64 */       if (this.reduce_seconds != _o_.reduce_seconds) return false;
/* 65 */       if (this.left_seconds != _o_.left_seconds) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.reduce_seconds;
/* 74 */     _h_ += this.left_seconds;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.reduce_seconds).append(",");
/* 82 */     _sb_.append(this.left_seconds).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SNotifyReduceTreasureHuntTime _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.reduce_seconds - _o_.reduce_seconds;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.left_seconds - _o_.left_seconds;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\treasurehunt\SNotifyReduceTreasureHuntTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */