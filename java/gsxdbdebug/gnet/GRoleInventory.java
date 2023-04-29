/*     */ package gnet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class GRoleInventory implements Marshal
/*     */ {
/*     */   public int id;
/*     */   public int pos;
/*     */   public int count;
/*     */   public int max_count;
/*     */   public byte container_id;
/*     */   public Octets data;
/*     */   public int guid1;
/*     */   public int guid2;
/*     */   public int mask;
/*     */   public int proctype;
/*     */   public int reserved;
/*     */   
/*     */   public GRoleInventory()
/*     */   {
/*  24 */     this.id = 0;
/*  25 */     this.pos = -1;
/*  26 */     this.count = 0;
/*  27 */     this.max_count = 0;
/*  28 */     this.container_id = 0;
/*  29 */     this.data = new Octets();
/*  30 */     this.guid1 = 0;
/*  31 */     this.guid2 = 0;
/*  32 */     this.mask = 0;
/*  33 */     this.proctype = 0;
/*  34 */     this.reserved = 0;
/*     */   }
/*     */   
/*     */   public GRoleInventory(int _id_, int _pos_, int _count_, int _max_count_, byte _container_id_, Octets _data_, int _guid1_, int _guid2_, int _mask_, int _proctype_, int _reserved_) {
/*  38 */     this.id = _id_;
/*  39 */     this.pos = _pos_;
/*  40 */     this.count = _count_;
/*  41 */     this.max_count = _max_count_;
/*  42 */     this.container_id = _container_id_;
/*  43 */     this.data = _data_;
/*  44 */     this.guid1 = _guid1_;
/*  45 */     this.guid2 = _guid2_;
/*  46 */     this.mask = _mask_;
/*  47 */     this.proctype = _proctype_;
/*  48 */     this.reserved = _reserved_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.id);
/*  57 */     _os_.marshal(this.pos);
/*  58 */     _os_.marshal(this.count);
/*  59 */     _os_.marshal(this.max_count);
/*  60 */     _os_.marshal(this.container_id);
/*  61 */     _os_.marshal(this.data);
/*  62 */     _os_.marshal(this.guid1);
/*  63 */     _os_.marshal(this.guid2);
/*  64 */     _os_.marshal(this.mask);
/*  65 */     _os_.marshal(this.proctype);
/*  66 */     _os_.marshal(this.reserved);
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  71 */     this.id = _os_.unmarshal_int();
/*  72 */     this.pos = _os_.unmarshal_int();
/*  73 */     this.count = _os_.unmarshal_int();
/*  74 */     this.max_count = _os_.unmarshal_int();
/*  75 */     this.container_id = _os_.unmarshal_byte();
/*  76 */     this.data = _os_.unmarshal_Octets();
/*  77 */     this.guid1 = _os_.unmarshal_int();
/*  78 */     this.guid2 = _os_.unmarshal_int();
/*  79 */     this.mask = _os_.unmarshal_int();
/*  80 */     this.proctype = _os_.unmarshal_int();
/*  81 */     this.reserved = _os_.unmarshal_int();
/*  82 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  86 */     if (_o1_ == this) return true;
/*  87 */     if ((_o1_ instanceof GRoleInventory)) {
/*  88 */       GRoleInventory _o_ = (GRoleInventory)_o1_;
/*  89 */       if (this.id != _o_.id) return false;
/*  90 */       if (this.pos != _o_.pos) return false;
/*  91 */       if (this.count != _o_.count) return false;
/*  92 */       if (this.max_count != _o_.max_count) return false;
/*  93 */       if (this.container_id != _o_.container_id) return false;
/*  94 */       if (!this.data.equals(_o_.data)) return false;
/*  95 */       if (this.guid1 != _o_.guid1) return false;
/*  96 */       if (this.guid2 != _o_.guid2) return false;
/*  97 */       if (this.mask != _o_.mask) return false;
/*  98 */       if (this.proctype != _o_.proctype) return false;
/*  99 */       if (this.reserved != _o_.reserved) return false;
/* 100 */       return true;
/*     */     }
/* 102 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 106 */     int _h_ = 0;
/* 107 */     _h_ += this.id;
/* 108 */     _h_ += this.pos;
/* 109 */     _h_ += this.count;
/* 110 */     _h_ += this.max_count;
/* 111 */     _h_ += this.container_id;
/* 112 */     _h_ += this.data.hashCode();
/* 113 */     _h_ += this.guid1;
/* 114 */     _h_ += this.guid2;
/* 115 */     _h_ += this.mask;
/* 116 */     _h_ += this.proctype;
/* 117 */     _h_ += this.reserved;
/* 118 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 122 */     StringBuilder _sb_ = new StringBuilder();
/* 123 */     _sb_.append("(");
/* 124 */     _sb_.append(this.id).append(",");
/* 125 */     _sb_.append(this.pos).append(",");
/* 126 */     _sb_.append(this.count).append(",");
/* 127 */     _sb_.append(this.max_count).append(",");
/* 128 */     _sb_.append(this.container_id).append(",");
/* 129 */     _sb_.append("B").append(this.data.size()).append(",");
/* 130 */     _sb_.append(this.guid1).append(",");
/* 131 */     _sb_.append(this.guid2).append(",");
/* 132 */     _sb_.append(this.mask).append(",");
/* 133 */     _sb_.append(this.proctype).append(",");
/* 134 */     _sb_.append(this.reserved).append(",");
/* 135 */     _sb_.append(")");
/* 136 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\GRoleInventory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */