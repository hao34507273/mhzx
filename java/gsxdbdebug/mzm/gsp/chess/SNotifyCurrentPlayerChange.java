/*    */ package mzm.gsp.chess;
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
/*    */ public class SNotifyCurrentPlayerChange
/*    */   extends __SNotifyCurrentPlayerChange__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12619040;
/*    */   public static final int SIDE_RED = 1;
/*    */   public static final int SIDE_BLUE = 2;
/*    */   public int current_player;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12619040;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SNotifyCurrentPlayerChange() {}
/*    */   
/*    */ 
/*    */ 
/*    */   public SNotifyCurrentPlayerChange(int _current_player_)
/*    */   {
/* 39 */     this.current_player = _current_player_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.current_player);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.current_player = _os_.unmarshal_int();
/* 53 */     if (!_validator_()) {
/* 54 */       throw new VerifyError("validator failed");
/*    */     }
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 60 */     if (_o1_ == this) return true;
/* 61 */     if ((_o1_ instanceof SNotifyCurrentPlayerChange)) {
/* 62 */       SNotifyCurrentPlayerChange _o_ = (SNotifyCurrentPlayerChange)_o1_;
/* 63 */       if (this.current_player != _o_.current_player) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += this.current_player;
/* 72 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 76 */     StringBuilder _sb_ = new StringBuilder();
/* 77 */     _sb_.append("(");
/* 78 */     _sb_.append(this.current_player).append(",");
/* 79 */     _sb_.append(")");
/* 80 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SNotifyCurrentPlayerChange _o_) {
/* 84 */     if (_o_ == this) return 0;
/* 85 */     int _c_ = 0;
/* 86 */     _c_ = this.current_player - _o_.current_player;
/* 87 */     if (0 != _c_) return _c_;
/* 88 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chess\SNotifyCurrentPlayerChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */