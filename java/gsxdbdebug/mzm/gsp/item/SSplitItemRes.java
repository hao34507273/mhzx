/*     */ package mzm.gsp.item;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSplitItemRes
/*     */   extends __SSplitItemRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584879;
/*     */   public long item_uuid;
/*     */   public int split_num;
/*     */   public HashMap<Integer, Integer> acquired_items;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12584879;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSplitItemRes()
/*     */   {
/*  33 */     this.acquired_items = new HashMap();
/*     */   }
/*     */   
/*     */   public SSplitItemRes(long _item_uuid_, int _split_num_, HashMap<Integer, Integer> _acquired_items_) {
/*  37 */     this.item_uuid = _item_uuid_;
/*  38 */     this.split_num = _split_num_;
/*  39 */     this.acquired_items = _acquired_items_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  43 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  47 */     _os_.marshal(this.item_uuid);
/*  48 */     _os_.marshal(this.split_num);
/*  49 */     _os_.compact_uint32(this.acquired_items.size());
/*  50 */     for (Map.Entry<Integer, Integer> _e_ : this.acquired_items.entrySet()) {
/*  51 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  52 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.item_uuid = _os_.unmarshal_long();
/*  59 */     this.split_num = _os_.unmarshal_int();
/*  60 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  62 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  64 */       int _v_ = _os_.unmarshal_int();
/*  65 */       this.acquired_items.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  67 */     if (!_validator_()) {
/*  68 */       throw new VerifyError("validator failed");
/*     */     }
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  74 */     if (_o1_ == this) return true;
/*  75 */     if ((_o1_ instanceof SSplitItemRes)) {
/*  76 */       SSplitItemRes _o_ = (SSplitItemRes)_o1_;
/*  77 */       if (this.item_uuid != _o_.item_uuid) return false;
/*  78 */       if (this.split_num != _o_.split_num) return false;
/*  79 */       if (!this.acquired_items.equals(_o_.acquired_items)) return false;
/*  80 */       return true;
/*     */     }
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  86 */     int _h_ = 0;
/*  87 */     _h_ += (int)this.item_uuid;
/*  88 */     _h_ += this.split_num;
/*  89 */     _h_ += this.acquired_items.hashCode();
/*  90 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  94 */     StringBuilder _sb_ = new StringBuilder();
/*  95 */     _sb_.append("(");
/*  96 */     _sb_.append(this.item_uuid).append(",");
/*  97 */     _sb_.append(this.split_num).append(",");
/*  98 */     _sb_.append(this.acquired_items).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SSplitItemRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */