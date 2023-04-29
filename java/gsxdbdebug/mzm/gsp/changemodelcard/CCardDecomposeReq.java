/*    */ package mzm.gsp.changemodelcard;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.changemodelcard.main.PCCardDecomposeReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CCardDecomposeReq
/*    */   extends __CCardDecomposeReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12624413;
/*    */   public ArrayList<Long> card_ids;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     if (roleId <= 0L)
/*    */     {
/* 23 */       return;
/*    */     }
/* 25 */     Role.addRoleProcedure(roleId, new PCCardDecomposeReq(roleId, this.card_ids));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 33 */     return 12624413;
/*    */   }
/*    */   
/*    */ 
/*    */   public CCardDecomposeReq()
/*    */   {
/* 39 */     this.card_ids = new ArrayList();
/*    */   }
/*    */   
/*    */   public CCardDecomposeReq(ArrayList<Long> _card_ids_) {
/* 43 */     this.card_ids = _card_ids_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.compact_uint32(this.card_ids.size());
/* 52 */     for (Long _v_ : this.card_ids) {
/* 53 */       _os_.marshal(_v_.longValue());
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 61 */       long _v_ = _os_.unmarshal_long();
/* 62 */       this.card_ids.add(Long.valueOf(_v_));
/*    */     }
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof CCardDecomposeReq)) {
/* 73 */       CCardDecomposeReq _o_ = (CCardDecomposeReq)_o1_;
/* 74 */       if (!this.card_ids.equals(_o_.card_ids)) return false;
/* 75 */       return true;
/*    */     }
/* 77 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 81 */     int _h_ = 0;
/* 82 */     _h_ += this.card_ids.hashCode();
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.card_ids).append(",");
/* 90 */     _sb_.append(")");
/* 91 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\CCardDecomposeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */