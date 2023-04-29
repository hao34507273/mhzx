/*     */ package mzm.gsp.crosscompete;
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
/*     */ 
/*     */ public class SGainPreciousItemsBrd
/*     */   extends __SGainPreciousItemsBrd__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12616710;
/*     */   public long roleid;
/*     */   public String name;
/*     */   public String faction;
/*     */   public HashMap<Integer, Integer> items;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12616710;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGainPreciousItemsBrd()
/*     */   {
/*  36 */     this.name = "";
/*  37 */     this.faction = "";
/*  38 */     this.items = new HashMap();
/*     */   }
/*     */   
/*     */   public SGainPreciousItemsBrd(long _roleid_, String _name_, String _faction_, HashMap<Integer, Integer> _items_) {
/*  42 */     this.roleid = _roleid_;
/*  43 */     this.name = _name_;
/*  44 */     this.faction = _faction_;
/*  45 */     this.items = _items_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.roleid);
/*  54 */     _os_.marshal(this.name, "UTF-16LE");
/*  55 */     _os_.marshal(this.faction, "UTF-16LE");
/*  56 */     _os_.compact_uint32(this.items.size());
/*  57 */     for (Map.Entry<Integer, Integer> _e_ : this.items.entrySet()) {
/*  58 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  59 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  65 */     this.roleid = _os_.unmarshal_long();
/*  66 */     this.name = _os_.unmarshal_String("UTF-16LE");
/*  67 */     this.faction = _os_.unmarshal_String("UTF-16LE");
/*  68 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  70 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  72 */       int _v_ = _os_.unmarshal_int();
/*  73 */       this.items.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  75 */     if (!_validator_()) {
/*  76 */       throw new VerifyError("validator failed");
/*     */     }
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  82 */     if (_o1_ == this) return true;
/*  83 */     if ((_o1_ instanceof SGainPreciousItemsBrd)) {
/*  84 */       SGainPreciousItemsBrd _o_ = (SGainPreciousItemsBrd)_o1_;
/*  85 */       if (this.roleid != _o_.roleid) return false;
/*  86 */       if (!this.name.equals(_o_.name)) return false;
/*  87 */       if (!this.faction.equals(_o_.faction)) return false;
/*  88 */       if (!this.items.equals(_o_.items)) return false;
/*  89 */       return true;
/*     */     }
/*  91 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  95 */     int _h_ = 0;
/*  96 */     _h_ += (int)this.roleid;
/*  97 */     _h_ += this.name.hashCode();
/*  98 */     _h_ += this.faction.hashCode();
/*  99 */     _h_ += this.items.hashCode();
/* 100 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 104 */     StringBuilder _sb_ = new StringBuilder();
/* 105 */     _sb_.append("(");
/* 106 */     _sb_.append(this.roleid).append(",");
/* 107 */     _sb_.append("T").append(this.name.length()).append(",");
/* 108 */     _sb_.append("T").append(this.faction.length()).append(",");
/* 109 */     _sb_.append(this.items).append(",");
/* 110 */     _sb_.append(")");
/* 111 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\SGainPreciousItemsBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */