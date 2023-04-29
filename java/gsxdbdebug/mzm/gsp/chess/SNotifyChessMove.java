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
/*    */ 
/*    */ public class SNotifyChessMove
/*    */   extends __SNotifyChessMove__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12619030;
/*    */   public int from_cell_index;
/*    */   public ChessPieceInfo to_cell_piece_info;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12619030;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SNotifyChessMove()
/*    */   {
/* 34 */     this.to_cell_piece_info = new ChessPieceInfo();
/*    */   }
/*    */   
/*    */   public SNotifyChessMove(int _from_cell_index_, ChessPieceInfo _to_cell_piece_info_) {
/* 38 */     this.from_cell_index = _from_cell_index_;
/* 39 */     this.to_cell_piece_info = _to_cell_piece_info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.to_cell_piece_info._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.from_cell_index);
/* 49 */     _os_.marshal(this.to_cell_piece_info);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.from_cell_index = _os_.unmarshal_int();
/* 55 */     this.to_cell_piece_info.unmarshal(_os_);
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SNotifyChessMove)) {
/* 65 */       SNotifyChessMove _o_ = (SNotifyChessMove)_o1_;
/* 66 */       if (this.from_cell_index != _o_.from_cell_index) return false;
/* 67 */       if (!this.to_cell_piece_info.equals(_o_.to_cell_piece_info)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.from_cell_index;
/* 76 */     _h_ += this.to_cell_piece_info.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.from_cell_index).append(",");
/* 84 */     _sb_.append(this.to_cell_piece_info).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SNotifyChessMove _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.from_cell_index - _o_.from_cell_index;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.to_cell_piece_info.compareTo(_o_.to_cell_piece_info);
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chess\SNotifyChessMove.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */