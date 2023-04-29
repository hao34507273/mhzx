/*    */ package mzm.gsp.item;
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
/*    */ 
/*    */ public class SResItemYuanbaoPrice
/*    */   extends __SResItemYuanbaoPrice__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584770;
/*    */   public HashMap<Integer, Integer> itemid2yuanbao;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12584770;
/*    */   }
/*    */   
/*    */ 
/*    */   public SResItemYuanbaoPrice()
/*    */   {
/* 31 */     this.itemid2yuanbao = new HashMap();
/*    */   }
/*    */   
/*    */   public SResItemYuanbaoPrice(HashMap<Integer, Integer> _itemid2yuanbao_) {
/* 35 */     this.itemid2yuanbao = _itemid2yuanbao_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 39 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 43 */     _os_.compact_uint32(this.itemid2yuanbao.size());
/* 44 */     for (Map.Entry<Integer, Integer> _e_ : this.itemid2yuanbao.entrySet()) {
/* 45 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 46 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 54 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 56 */       int _v_ = _os_.unmarshal_int();
/* 57 */       this.itemid2yuanbao.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SResItemYuanbaoPrice)) {
/* 68 */       SResItemYuanbaoPrice _o_ = (SResItemYuanbaoPrice)_o1_;
/* 69 */       if (!this.itemid2yuanbao.equals(_o_.itemid2yuanbao)) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.itemid2yuanbao.hashCode();
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.itemid2yuanbao).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SResItemYuanbaoPrice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */