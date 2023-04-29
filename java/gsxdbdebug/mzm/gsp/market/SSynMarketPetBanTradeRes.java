/*    */ package mzm.gsp.market;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashSet;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSynMarketPetBanTradeRes
/*    */   extends __SSynMarketPetBanTradeRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12601458;
/*    */   public HashSet<Integer> petcfgids;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12601458;
/*    */   }
/*    */   
/*    */ 
/*    */   public SSynMarketPetBanTradeRes()
/*    */   {
/* 31 */     this.petcfgids = new HashSet();
/*    */   }
/*    */   
/*    */   public SSynMarketPetBanTradeRes(HashSet<Integer> _petcfgids_) {
/* 35 */     this.petcfgids = _petcfgids_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 39 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 43 */     _os_.compact_uint32(this.petcfgids.size());
/* 44 */     for (Integer _v_ : this.petcfgids) {
/* 45 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 51 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 53 */       int _v_ = _os_.unmarshal_int();
/* 54 */       this.petcfgids.add(Integer.valueOf(_v_));
/*    */     }
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SSynMarketPetBanTradeRes)) {
/* 65 */       SSynMarketPetBanTradeRes _o_ = (SSynMarketPetBanTradeRes)_o1_;
/* 66 */       if (!this.petcfgids.equals(_o_.petcfgids)) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += this.petcfgids.hashCode();
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.petcfgids).append(",");
/* 82 */     _sb_.append(")");
/* 83 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\SSynMarketPetBanTradeRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */