/*     */ package mzm.gsp.luckybag;
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
/*     */ public class SBrocastLuckyBagItem
/*     */   extends __SBrocastLuckyBagItem__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12607492;
/*     */   public long roleid;
/*     */   public Octets role_name;
/*     */   public int map_item_cfgid;
/*     */   public HashMap<Integer, Integer> items;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12607492;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SBrocastLuckyBagItem()
/*     */   {
/*  36 */     this.role_name = new Octets();
/*  37 */     this.items = new HashMap();
/*     */   }
/*     */   
/*     */   public SBrocastLuckyBagItem(long _roleid_, Octets _role_name_, int _map_item_cfgid_, HashMap<Integer, Integer> _items_) {
/*  41 */     this.roleid = _roleid_;
/*  42 */     this.role_name = _role_name_;
/*  43 */     this.map_item_cfgid = _map_item_cfgid_;
/*  44 */     this.items = _items_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.roleid);
/*  53 */     _os_.marshal(this.role_name);
/*  54 */     _os_.marshal(this.map_item_cfgid);
/*  55 */     _os_.compact_uint32(this.items.size());
/*  56 */     for (Map.Entry<Integer, Integer> _e_ : this.items.entrySet()) {
/*  57 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  58 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.roleid = _os_.unmarshal_long();
/*  65 */     this.role_name = _os_.unmarshal_Octets();
/*  66 */     this.map_item_cfgid = _os_.unmarshal_int();
/*  67 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  69 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  71 */       int _v_ = _os_.unmarshal_int();
/*  72 */       this.items.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  74 */     if (!_validator_()) {
/*  75 */       throw new VerifyError("validator failed");
/*     */     }
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  81 */     if (_o1_ == this) return true;
/*  82 */     if ((_o1_ instanceof SBrocastLuckyBagItem)) {
/*  83 */       SBrocastLuckyBagItem _o_ = (SBrocastLuckyBagItem)_o1_;
/*  84 */       if (this.roleid != _o_.roleid) return false;
/*  85 */       if (!this.role_name.equals(_o_.role_name)) return false;
/*  86 */       if (this.map_item_cfgid != _o_.map_item_cfgid) return false;
/*  87 */       if (!this.items.equals(_o_.items)) return false;
/*  88 */       return true;
/*     */     }
/*  90 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  94 */     int _h_ = 0;
/*  95 */     _h_ += (int)this.roleid;
/*  96 */     _h_ += this.role_name.hashCode();
/*  97 */     _h_ += this.map_item_cfgid;
/*  98 */     _h_ += this.items.hashCode();
/*  99 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 103 */     StringBuilder _sb_ = new StringBuilder();
/* 104 */     _sb_.append("(");
/* 105 */     _sb_.append(this.roleid).append(",");
/* 106 */     _sb_.append("B").append(this.role_name.size()).append(",");
/* 107 */     _sb_.append(this.map_item_cfgid).append(",");
/* 108 */     _sb_.append(this.items).append(",");
/* 109 */     _sb_.append(")");
/* 110 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckybag\SBrocastLuckyBagItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */