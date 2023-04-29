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
/*    */ public class SResItemYuanbaoPriceWithId
/*    */   extends __SResItemYuanbaoPriceWithId__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584771;
/*    */   public int uid;
/*    */   public HashMap<Integer, Integer> itemid2yuanbao;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12584771;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SResItemYuanbaoPriceWithId()
/*    */   {
/* 32 */     this.itemid2yuanbao = new HashMap();
/*    */   }
/*    */   
/*    */   public SResItemYuanbaoPriceWithId(int _uid_, HashMap<Integer, Integer> _itemid2yuanbao_) {
/* 36 */     this.uid = _uid_;
/* 37 */     this.itemid2yuanbao = _itemid2yuanbao_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.marshal(this.uid);
/* 46 */     _os_.compact_uint32(this.itemid2yuanbao.size());
/* 47 */     for (Map.Entry<Integer, Integer> _e_ : this.itemid2yuanbao.entrySet()) {
/* 48 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 49 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.uid = _os_.unmarshal_int();
/* 56 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 58 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 60 */       int _v_ = _os_.unmarshal_int();
/* 61 */       this.itemid2yuanbao.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 63 */     if (!_validator_()) {
/* 64 */       throw new VerifyError("validator failed");
/*    */     }
/* 66 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 70 */     if (_o1_ == this) return true;
/* 71 */     if ((_o1_ instanceof SResItemYuanbaoPriceWithId)) {
/* 72 */       SResItemYuanbaoPriceWithId _o_ = (SResItemYuanbaoPriceWithId)_o1_;
/* 73 */       if (this.uid != _o_.uid) return false;
/* 74 */       if (!this.itemid2yuanbao.equals(_o_.itemid2yuanbao)) return false;
/* 75 */       return true;
/*    */     }
/* 77 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 81 */     int _h_ = 0;
/* 82 */     _h_ += this.uid;
/* 83 */     _h_ += this.itemid2yuanbao.hashCode();
/* 84 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 88 */     StringBuilder _sb_ = new StringBuilder();
/* 89 */     _sb_.append("(");
/* 90 */     _sb_.append(this.uid).append(",");
/* 91 */     _sb_.append(this.itemid2yuanbao).append(",");
/* 92 */     _sb_.append(")");
/* 93 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SResItemYuanbaoPriceWithId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */