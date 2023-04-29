/*    */ package mzm.gsp.chess;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class ChessPieceInfo
/*    */   implements Marshal, Comparable<ChessPieceInfo>
/*    */ {
/*    */   public int chess_piece_index;
/*    */   public int chess_cell_index;
/*    */   public int owner;
/*    */   
/*    */   public ChessPieceInfo() {}
/*    */   
/*    */   public ChessPieceInfo(int _chess_piece_index_, int _chess_cell_index_, int _owner_)
/*    */   {
/* 19 */     this.chess_piece_index = _chess_piece_index_;
/* 20 */     this.chess_cell_index = _chess_cell_index_;
/* 21 */     this.owner = _owner_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.chess_piece_index);
/* 30 */     _os_.marshal(this.chess_cell_index);
/* 31 */     _os_.marshal(this.owner);
/* 32 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 36 */     this.chess_piece_index = _os_.unmarshal_int();
/* 37 */     this.chess_cell_index = _os_.unmarshal_int();
/* 38 */     this.owner = _os_.unmarshal_int();
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 43 */     if (_o1_ == this) return true;
/* 44 */     if ((_o1_ instanceof ChessPieceInfo)) {
/* 45 */       ChessPieceInfo _o_ = (ChessPieceInfo)_o1_;
/* 46 */       if (this.chess_piece_index != _o_.chess_piece_index) return false;
/* 47 */       if (this.chess_cell_index != _o_.chess_cell_index) return false;
/* 48 */       if (this.owner != _o_.owner) return false;
/* 49 */       return true;
/*    */     }
/* 51 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 55 */     int _h_ = 0;
/* 56 */     _h_ += this.chess_piece_index;
/* 57 */     _h_ += this.chess_cell_index;
/* 58 */     _h_ += this.owner;
/* 59 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 63 */     StringBuilder _sb_ = new StringBuilder();
/* 64 */     _sb_.append("(");
/* 65 */     _sb_.append(this.chess_piece_index).append(",");
/* 66 */     _sb_.append(this.chess_cell_index).append(",");
/* 67 */     _sb_.append(this.owner).append(",");
/* 68 */     _sb_.append(")");
/* 69 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(ChessPieceInfo _o_) {
/* 73 */     if (_o_ == this) return 0;
/* 74 */     int _c_ = 0;
/* 75 */     _c_ = this.chess_piece_index - _o_.chess_piece_index;
/* 76 */     if (0 != _c_) return _c_;
/* 77 */     _c_ = this.chess_cell_index - _o_.chess_cell_index;
/* 78 */     if (0 != _c_) return _c_;
/* 79 */     _c_ = this.owner - _o_.owner;
/* 80 */     if (0 != _c_) return _c_;
/* 81 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chess\ChessPieceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */