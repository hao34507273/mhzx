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
/*    */ public class SUseMarriageSugerItem
/*    */   extends __SUseMarriageSugerItem__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584829;
/*    */   public static final int BAG_NOT_FULL = 0;
/*    */   public static final int BAG_FULL = 1;
/*    */   public HashMap<Integer, Integer> item2count;
/*    */   public int isbagfull;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12584829;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SUseMarriageSugerItem()
/*    */   {
/* 37 */     this.item2count = new HashMap();
/*    */   }
/*    */   
/*    */   public SUseMarriageSugerItem(HashMap<Integer, Integer> _item2count_, int _isbagfull_) {
/* 41 */     this.item2count = _item2count_;
/* 42 */     this.isbagfull = _isbagfull_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.compact_uint32(this.item2count.size());
/* 51 */     for (Map.Entry<Integer, Integer> _e_ : this.item2count.entrySet()) {
/* 52 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 53 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 55 */     _os_.marshal(this.isbagfull);
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 60 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 62 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 64 */       int _v_ = _os_.unmarshal_int();
/* 65 */       this.item2count.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 67 */     this.isbagfull = _os_.unmarshal_int();
/* 68 */     if (!_validator_()) {
/* 69 */       throw new VerifyError("validator failed");
/*    */     }
/* 71 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 75 */     if (_o1_ == this) return true;
/* 76 */     if ((_o1_ instanceof SUseMarriageSugerItem)) {
/* 77 */       SUseMarriageSugerItem _o_ = (SUseMarriageSugerItem)_o1_;
/* 78 */       if (!this.item2count.equals(_o_.item2count)) return false;
/* 79 */       if (this.isbagfull != _o_.isbagfull) return false;
/* 80 */       return true;
/*    */     }
/* 82 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 86 */     int _h_ = 0;
/* 87 */     _h_ += this.item2count.hashCode();
/* 88 */     _h_ += this.isbagfull;
/* 89 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 93 */     StringBuilder _sb_ = new StringBuilder();
/* 94 */     _sb_.append("(");
/* 95 */     _sb_.append(this.item2count).append(",");
/* 96 */     _sb_.append(this.isbagfull).append(",");
/* 97 */     _sb_.append(")");
/* 98 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SUseMarriageSugerItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */