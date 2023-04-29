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
/*    */ 
/*    */ public class SChessMoveSuccessRep
/*    */   extends __SChessMoveSuccessRep__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12619036;
/*    */   public ChessPieceInfo to_cell_piece_info;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12619036;
/*    */   }
/*    */   
/*    */ 
/*    */   public SChessMoveSuccessRep()
/*    */   {
/* 33 */     this.to_cell_piece_info = new ChessPieceInfo();
/*    */   }
/*    */   
/*    */   public SChessMoveSuccessRep(ChessPieceInfo _to_cell_piece_info_) {
/* 37 */     this.to_cell_piece_info = _to_cell_piece_info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     if (!this.to_cell_piece_info._validator_()) return false;
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.to_cell_piece_info);
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 51 */     this.to_cell_piece_info.unmarshal(_os_);
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SChessMoveSuccessRep)) {
/* 61 */       SChessMoveSuccessRep _o_ = (SChessMoveSuccessRep)_o1_;
/* 62 */       if (!this.to_cell_piece_info.equals(_o_.to_cell_piece_info)) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += this.to_cell_piece_info.hashCode();
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append(this.to_cell_piece_info).append(",");
/* 78 */     _sb_.append(")");
/* 79 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SChessMoveSuccessRep _o_) {
/* 83 */     if (_o_ == this) return 0;
/* 84 */     int _c_ = 0;
/* 85 */     _c_ = this.to_cell_piece_info.compareTo(_o_.to_cell_piece_info);
/* 86 */     if (0 != _c_) return _c_;
/* 87 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chess\SChessMoveSuccessRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */