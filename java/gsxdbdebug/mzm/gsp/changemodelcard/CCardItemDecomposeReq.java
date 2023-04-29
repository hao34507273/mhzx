/*    */ package mzm.gsp.changemodelcard;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.changemodelcard.main.PCCardItemDecomposeReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CCardItemDecomposeReq
/*    */   extends __CCardItemDecomposeReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12624396;
/*    */   public ArrayList<Long> item_uuids;
/*    */   public byte decompose_one;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     if (roleId <= 0L)
/*    */     {
/* 23 */       return;
/*    */     }
/* 25 */     boolean decomposeOne = this.decompose_one > 0;
/* 26 */     Role.addRoleProcedure(roleId, new PCCardItemDecomposeReq(roleId, this.item_uuids, decomposeOne));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 34 */     return 12624396;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CCardItemDecomposeReq()
/*    */   {
/* 41 */     this.item_uuids = new ArrayList();
/*    */   }
/*    */   
/*    */   public CCardItemDecomposeReq(ArrayList<Long> _item_uuids_, byte _decompose_one_) {
/* 45 */     this.item_uuids = _item_uuids_;
/* 46 */     this.decompose_one = _decompose_one_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 50 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 54 */     _os_.compact_uint32(this.item_uuids.size());
/* 55 */     for (Long _v_ : this.item_uuids) {
/* 56 */       _os_.marshal(_v_.longValue());
/*    */     }
/* 58 */     _os_.marshal(this.decompose_one);
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 63 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 65 */       long _v_ = _os_.unmarshal_long();
/* 66 */       this.item_uuids.add(Long.valueOf(_v_));
/*    */     }
/* 68 */     this.decompose_one = _os_.unmarshal_byte();
/* 69 */     if (!_validator_()) {
/* 70 */       throw new VerifyError("validator failed");
/*    */     }
/* 72 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 76 */     if (_o1_ == this) return true;
/* 77 */     if ((_o1_ instanceof CCardItemDecomposeReq)) {
/* 78 */       CCardItemDecomposeReq _o_ = (CCardItemDecomposeReq)_o1_;
/* 79 */       if (!this.item_uuids.equals(_o_.item_uuids)) return false;
/* 80 */       if (this.decompose_one != _o_.decompose_one) return false;
/* 81 */       return true;
/*    */     }
/* 83 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 87 */     int _h_ = 0;
/* 88 */     _h_ += this.item_uuids.hashCode();
/* 89 */     _h_ += this.decompose_one;
/* 90 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 94 */     StringBuilder _sb_ = new StringBuilder();
/* 95 */     _sb_.append("(");
/* 96 */     _sb_.append(this.item_uuids).append(",");
/* 97 */     _sb_.append(this.decompose_one).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\CCardItemDecomposeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */