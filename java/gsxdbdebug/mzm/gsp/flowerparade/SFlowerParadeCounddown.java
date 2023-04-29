/*     */ package mzm.gsp.flowerparade;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SFlowerParadeCounddown
/*     */   extends __SFlowerParadeCounddown__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12625667;
/*     */   public int activityid;
/*     */   public ArrayList<ParadeRoleInfo> rolelist;
/*     */   public int ocp;
/*     */   public int map;
/*     */   public long starttime;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12625667;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SFlowerParadeCounddown()
/*     */   {
/*  37 */     this.rolelist = new ArrayList();
/*     */   }
/*     */   
/*     */   public SFlowerParadeCounddown(int _activityid_, ArrayList<ParadeRoleInfo> _rolelist_, int _ocp_, int _map_, long _starttime_) {
/*  41 */     this.activityid = _activityid_;
/*  42 */     this.rolelist = _rolelist_;
/*  43 */     this.ocp = _ocp_;
/*  44 */     this.map = _map_;
/*  45 */     this.starttime = _starttime_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     for (ParadeRoleInfo _v_ : this.rolelist)
/*  50 */       if (!_v_._validator_()) return false;
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.activityid);
/*  56 */     _os_.compact_uint32(this.rolelist.size());
/*  57 */     for (ParadeRoleInfo _v_ : this.rolelist) {
/*  58 */       _os_.marshal(_v_);
/*     */     }
/*  60 */     _os_.marshal(this.ocp);
/*  61 */     _os_.marshal(this.map);
/*  62 */     _os_.marshal(this.starttime);
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  67 */     this.activityid = _os_.unmarshal_int();
/*  68 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  69 */       ParadeRoleInfo _v_ = new ParadeRoleInfo();
/*  70 */       _v_.unmarshal(_os_);
/*  71 */       this.rolelist.add(_v_);
/*     */     }
/*  73 */     this.ocp = _os_.unmarshal_int();
/*  74 */     this.map = _os_.unmarshal_int();
/*  75 */     this.starttime = _os_.unmarshal_long();
/*  76 */     if (!_validator_()) {
/*  77 */       throw new VerifyError("validator failed");
/*     */     }
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  83 */     if (_o1_ == this) return true;
/*  84 */     if ((_o1_ instanceof SFlowerParadeCounddown)) {
/*  85 */       SFlowerParadeCounddown _o_ = (SFlowerParadeCounddown)_o1_;
/*  86 */       if (this.activityid != _o_.activityid) return false;
/*  87 */       if (!this.rolelist.equals(_o_.rolelist)) return false;
/*  88 */       if (this.ocp != _o_.ocp) return false;
/*  89 */       if (this.map != _o_.map) return false;
/*  90 */       if (this.starttime != _o_.starttime) return false;
/*  91 */       return true;
/*     */     }
/*  93 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  97 */     int _h_ = 0;
/*  98 */     _h_ += this.activityid;
/*  99 */     _h_ += this.rolelist.hashCode();
/* 100 */     _h_ += this.ocp;
/* 101 */     _h_ += this.map;
/* 102 */     _h_ += (int)this.starttime;
/* 103 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 107 */     StringBuilder _sb_ = new StringBuilder();
/* 108 */     _sb_.append("(");
/* 109 */     _sb_.append(this.activityid).append(",");
/* 110 */     _sb_.append(this.rolelist).append(",");
/* 111 */     _sb_.append(this.ocp).append(",");
/* 112 */     _sb_.append(this.map).append(",");
/* 113 */     _sb_.append(this.starttime).append(",");
/* 114 */     _sb_.append(")");
/* 115 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\flowerparade\SFlowerParadeCounddown.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */