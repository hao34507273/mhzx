/*    */ package mzm.gsp.market;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SQueryPubOrSellNumberRes
/*    */   extends __SQueryPubOrSellNumberRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12601442;
/*    */   public HashMap<Integer, Integer> subid2num;
/*    */   public int puborsell;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12601442;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SQueryPubOrSellNumberRes()
/*    */   {
/* 32 */     this.subid2num = new HashMap();
/*    */   }
/*    */   
/*    */   public SQueryPubOrSellNumberRes(HashMap<Integer, Integer> _subid2num_, int _puborsell_) {
/* 36 */     this.subid2num = _subid2num_;
/* 37 */     this.puborsell = _puborsell_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.compact_uint32(this.subid2num.size());
/* 46 */     for (Map.Entry<Integer, Integer> _e_ : this.subid2num.entrySet()) {
/* 47 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 48 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 50 */     _os_.marshal(this.puborsell);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 57 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 59 */       int _v_ = _os_.unmarshal_int();
/* 60 */       this.subid2num.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 62 */     this.puborsell = _os_.unmarshal_int();
/* 63 */     if (!_validator_()) {
/* 64 */       throw new VerifyError("validator failed");
/*    */     }
/* 66 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 70 */     if (_o1_ == this) return true;
/* 71 */     if ((_o1_ instanceof SQueryPubOrSellNumberRes)) {
/* 72 */       SQueryPubOrSellNumberRes _o_ = (SQueryPubOrSellNumberRes)_o1_;
/* 73 */       if (!this.subid2num.equals(_o_.subid2num)) return false;
/* 74 */       if (this.puborsell != _o_.puborsell) return false;
/* 75 */       return true;
/*    */     }
/* 77 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 81 */     int _h_ = 0;
/* 82 */     _h_ += this.subid2num.hashCode();
/* 83 */     _h_ += this.puborsell;
/* 84 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 88 */     StringBuilder _sb_ = new StringBuilder();
/* 89 */     _sb_.append("(");
/* 90 */     _sb_.append(this.subid2num).append(",");
/* 91 */     _sb_.append(this.puborsell).append(",");
/* 92 */     _sb_.append(")");
/* 93 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\SQueryPubOrSellNumberRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */