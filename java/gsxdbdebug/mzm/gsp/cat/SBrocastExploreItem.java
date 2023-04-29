/*     */ package mzm.gsp.cat;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SBrocastExploreItem
/*     */   extends __SBrocastExploreItem__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12605721;
/*     */   public long roleid;
/*     */   public Octets role_name;
/*     */   public HashMap<Integer, Integer> items;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12605721;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SBrocastExploreItem()
/*     */   {
/*  35 */     this.role_name = new Octets();
/*  36 */     this.items = new HashMap();
/*     */   }
/*     */   
/*     */   public SBrocastExploreItem(long _roleid_, Octets _role_name_, HashMap<Integer, Integer> _items_) {
/*  40 */     this.roleid = _roleid_;
/*  41 */     this.role_name = _role_name_;
/*  42 */     this.items = _items_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.roleid);
/*  51 */     _os_.marshal(this.role_name);
/*  52 */     _os_.compact_uint32(this.items.size());
/*  53 */     for (Map.Entry<Integer, Integer> _e_ : this.items.entrySet()) {
/*  54 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  55 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.roleid = _os_.unmarshal_long();
/*  62 */     this.role_name = _os_.unmarshal_Octets();
/*  63 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  65 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  67 */       int _v_ = _os_.unmarshal_int();
/*  68 */       this.items.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  70 */     if (!_validator_()) {
/*  71 */       throw new VerifyError("validator failed");
/*     */     }
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  77 */     if (_o1_ == this) return true;
/*  78 */     if ((_o1_ instanceof SBrocastExploreItem)) {
/*  79 */       SBrocastExploreItem _o_ = (SBrocastExploreItem)_o1_;
/*  80 */       if (this.roleid != _o_.roleid) return false;
/*  81 */       if (!this.role_name.equals(_o_.role_name)) return false;
/*  82 */       if (!this.items.equals(_o_.items)) return false;
/*  83 */       return true;
/*     */     }
/*  85 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  89 */     int _h_ = 0;
/*  90 */     _h_ += (int)this.roleid;
/*  91 */     _h_ += this.role_name.hashCode();
/*  92 */     _h_ += this.items.hashCode();
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.roleid).append(",");
/* 100 */     _sb_.append("B").append(this.role_name.size()).append(",");
/* 101 */     _sb_.append(this.items).append(",");
/* 102 */     _sb_.append(")");
/* 103 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cat\SBrocastExploreItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */