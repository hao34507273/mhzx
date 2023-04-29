/*    */ package mzm.gsp.chess;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SChessTurnOverFailRep
/*    */   extends __SChessTurnOverFailRep__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12619034;
/*    */   public static final int NOT_IN_CHESS_GAME = -1;
/*    */   public static final int NOT_SELF_ROUND = -2;
/*    */   public static final int TURN_OVER_CELL_NOT_EXIST = -3;
/*    */   public static final int TURN_OVER_CELL_EMPTY = -4;
/*    */   public static final int TURN_OVER_CHESS_ALREADY_VISIBLE = -5;
/*    */   public static final int OPERATE_TOO_FAST = -6;
/*    */   public int error_code;
/*    */   public ArrayList<String> params;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12619034;
/*    */   }
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
/*    */   public SChessTurnOverFailRep()
/*    */   {
/* 41 */     this.params = new ArrayList();
/*    */   }
/*    */   
/*    */   public SChessTurnOverFailRep(int _error_code_, ArrayList<String> _params_) {
/* 45 */     this.error_code = _error_code_;
/* 46 */     this.params = _params_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 50 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 54 */     _os_.marshal(this.error_code);
/* 55 */     _os_.compact_uint32(this.params.size());
/* 56 */     for (String _v_ : this.params) {
/* 57 */       _os_.marshal(_v_, "UTF-16LE");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 63 */     this.error_code = _os_.unmarshal_int();
/* 64 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 66 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/* 67 */       this.params.add(_v_);
/*    */     }
/* 69 */     if (!_validator_()) {
/* 70 */       throw new VerifyError("validator failed");
/*    */     }
/* 72 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 76 */     if (_o1_ == this) return true;
/* 77 */     if ((_o1_ instanceof SChessTurnOverFailRep)) {
/* 78 */       SChessTurnOverFailRep _o_ = (SChessTurnOverFailRep)_o1_;
/* 79 */       if (this.error_code != _o_.error_code) return false;
/* 80 */       if (!this.params.equals(_o_.params)) return false;
/* 81 */       return true;
/*    */     }
/* 83 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 87 */     int _h_ = 0;
/* 88 */     _h_ += this.error_code;
/* 89 */     _h_ += this.params.hashCode();
/* 90 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 94 */     StringBuilder _sb_ = new StringBuilder();
/* 95 */     _sb_.append("(");
/* 96 */     _sb_.append(this.error_code).append(",");
/* 97 */     _sb_.append(this.params).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chess\SChessTurnOverFailRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */