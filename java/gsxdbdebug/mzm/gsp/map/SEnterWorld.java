/*     */ package mzm.gsp.map;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ 
/*     */ public class SEnterWorld
/*     */   extends __SEnterWorld__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590865;
/*     */   public static final int TYPE_PET = 1;
/*     */   public static final int TYPE_CHILDREN = 2;
/*     */   public int mapid;
/*     */   public int mapinstanceid;
/*     */   public Octets modelinfo;
/*     */   public Location pos;
/*     */   public int direction;
/*     */   public HashMap<Integer, Octets> othermodel;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12590865;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SEnterWorld()
/*     */   {
/*  41 */     this.modelinfo = new Octets();
/*  42 */     this.pos = new Location();
/*  43 */     this.othermodel = new HashMap();
/*     */   }
/*     */   
/*     */   public SEnterWorld(int _mapid_, int _mapinstanceid_, Octets _modelinfo_, Location _pos_, int _direction_, HashMap<Integer, Octets> _othermodel_) {
/*  47 */     this.mapid = _mapid_;
/*  48 */     this.mapinstanceid = _mapinstanceid_;
/*  49 */     this.modelinfo = _modelinfo_;
/*  50 */     this.pos = _pos_;
/*  51 */     this.direction = _direction_;
/*  52 */     this.othermodel = _othermodel_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  56 */     if (!this.pos._validator_()) return false;
/*  57 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  61 */     _os_.marshal(this.mapid);
/*  62 */     _os_.marshal(this.mapinstanceid);
/*  63 */     _os_.marshal(this.modelinfo);
/*  64 */     _os_.marshal(this.pos);
/*  65 */     _os_.marshal(this.direction);
/*  66 */     _os_.compact_uint32(this.othermodel.size());
/*  67 */     for (Map.Entry<Integer, Octets> _e_ : this.othermodel.entrySet()) {
/*  68 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  69 */       _os_.marshal((Octets)_e_.getValue());
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  75 */     this.mapid = _os_.unmarshal_int();
/*  76 */     this.mapinstanceid = _os_.unmarshal_int();
/*  77 */     this.modelinfo = _os_.unmarshal_Octets();
/*  78 */     this.pos.unmarshal(_os_);
/*  79 */     this.direction = _os_.unmarshal_int();
/*  80 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  82 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  84 */       Octets _v_ = _os_.unmarshal_Octets();
/*  85 */       this.othermodel.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  87 */     if (!_validator_()) {
/*  88 */       throw new VerifyError("validator failed");
/*     */     }
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  94 */     if (_o1_ == this) return true;
/*  95 */     if ((_o1_ instanceof SEnterWorld)) {
/*  96 */       SEnterWorld _o_ = (SEnterWorld)_o1_;
/*  97 */       if (this.mapid != _o_.mapid) return false;
/*  98 */       if (this.mapinstanceid != _o_.mapinstanceid) return false;
/*  99 */       if (!this.modelinfo.equals(_o_.modelinfo)) return false;
/* 100 */       if (!this.pos.equals(_o_.pos)) return false;
/* 101 */       if (this.direction != _o_.direction) return false;
/* 102 */       if (!this.othermodel.equals(_o_.othermodel)) return false;
/* 103 */       return true;
/*     */     }
/* 105 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 109 */     int _h_ = 0;
/* 110 */     _h_ += this.mapid;
/* 111 */     _h_ += this.mapinstanceid;
/* 112 */     _h_ += this.modelinfo.hashCode();
/* 113 */     _h_ += this.pos.hashCode();
/* 114 */     _h_ += this.direction;
/* 115 */     _h_ += this.othermodel.hashCode();
/* 116 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 120 */     StringBuilder _sb_ = new StringBuilder();
/* 121 */     _sb_.append("(");
/* 122 */     _sb_.append(this.mapid).append(",");
/* 123 */     _sb_.append(this.mapinstanceid).append(",");
/* 124 */     _sb_.append("B").append(this.modelinfo.size()).append(",");
/* 125 */     _sb_.append(this.pos).append(",");
/* 126 */     _sb_.append(this.direction).append(",");
/* 127 */     _sb_.append(this.othermodel).append(",");
/* 128 */     _sb_.append(")");
/* 129 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\SEnterWorld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */