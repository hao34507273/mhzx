/*    */ package mzm.gsp.superequipment;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.superequipment.jewel.main.PCJewelTransferPriceReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CJewelTransferPriceReq
/*    */   extends __CJewelTransferPriceReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12618787;
/*    */   public ArrayList<Integer> jewelcfgids;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId <= 0L)
/*    */     {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PCJewelTransferPriceReq(roleId, this.jewelcfgids));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 33 */     return 12618787;
/*    */   }
/*    */   
/*    */ 
/*    */   public CJewelTransferPriceReq()
/*    */   {
/* 39 */     this.jewelcfgids = new ArrayList();
/*    */   }
/*    */   
/*    */   public CJewelTransferPriceReq(ArrayList<Integer> _jewelcfgids_) {
/* 43 */     this.jewelcfgids = _jewelcfgids_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.compact_uint32(this.jewelcfgids.size());
/* 52 */     for (Integer _v_ : this.jewelcfgids) {
/* 53 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 61 */       int _v_ = _os_.unmarshal_int();
/* 62 */       this.jewelcfgids.add(Integer.valueOf(_v_));
/*    */     }
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof CJewelTransferPriceReq)) {
/* 73 */       CJewelTransferPriceReq _o_ = (CJewelTransferPriceReq)_o1_;
/* 74 */       if (!this.jewelcfgids.equals(_o_.jewelcfgids)) return false;
/* 75 */       return true;
/*    */     }
/* 77 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 81 */     int _h_ = 0;
/* 82 */     _h_ += this.jewelcfgids.hashCode();
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.jewelcfgids).append(",");
/* 90 */     _sb_.append(")");
/* 91 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\CJewelTransferPriceReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */