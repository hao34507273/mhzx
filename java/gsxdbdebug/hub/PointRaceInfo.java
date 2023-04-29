/*     */ package hub;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class PointRaceInfo implements Marshal
/*     */ {
/*     */   public int activity_cfgid;
/*     */   public int zone;
/*     */   public int time_point_cfgid;
/*     */   public long start_time;
/*     */   public int last_time;
/*     */   public ArrayList<Integer> pre_time_points;
/*     */   public int index;
/*     */   public byte backup;
/*     */   
/*     */   public PointRaceInfo()
/*     */   {
/*  21 */     this.pre_time_points = new ArrayList();
/*     */   }
/*     */   
/*     */   public PointRaceInfo(int _activity_cfgid_, int _zone_, int _time_point_cfgid_, long _start_time_, int _last_time_, ArrayList<Integer> _pre_time_points_, int _index_, byte _backup_) {
/*  25 */     this.activity_cfgid = _activity_cfgid_;
/*  26 */     this.zone = _zone_;
/*  27 */     this.time_point_cfgid = _time_point_cfgid_;
/*  28 */     this.start_time = _start_time_;
/*  29 */     this.last_time = _last_time_;
/*  30 */     this.pre_time_points = _pre_time_points_;
/*  31 */     this.index = _index_;
/*  32 */     this.backup = _backup_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  36 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  40 */     _os_.marshal(this.activity_cfgid);
/*  41 */     _os_.marshal(this.zone);
/*  42 */     _os_.marshal(this.time_point_cfgid);
/*  43 */     _os_.marshal(this.start_time);
/*  44 */     _os_.marshal(this.last_time);
/*  45 */     _os_.compact_uint32(this.pre_time_points.size());
/*  46 */     for (Integer _v_ : this.pre_time_points) {
/*  47 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  49 */     _os_.marshal(this.index);
/*  50 */     _os_.marshal(this.backup);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.activity_cfgid = _os_.unmarshal_int();
/*  56 */     this.zone = _os_.unmarshal_int();
/*  57 */     this.time_point_cfgid = _os_.unmarshal_int();
/*  58 */     this.start_time = _os_.unmarshal_long();
/*  59 */     this.last_time = _os_.unmarshal_int();
/*  60 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  62 */       int _v_ = _os_.unmarshal_int();
/*  63 */       this.pre_time_points.add(Integer.valueOf(_v_));
/*     */     }
/*  65 */     this.index = _os_.unmarshal_int();
/*  66 */     this.backup = _os_.unmarshal_byte();
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof PointRaceInfo)) {
/*  73 */       PointRaceInfo _o_ = (PointRaceInfo)_o1_;
/*  74 */       if (this.activity_cfgid != _o_.activity_cfgid) return false;
/*  75 */       if (this.zone != _o_.zone) return false;
/*  76 */       if (this.time_point_cfgid != _o_.time_point_cfgid) return false;
/*  77 */       if (this.start_time != _o_.start_time) return false;
/*  78 */       if (this.last_time != _o_.last_time) return false;
/*  79 */       if (!this.pre_time_points.equals(_o_.pre_time_points)) return false;
/*  80 */       if (this.index != _o_.index) return false;
/*  81 */       if (this.backup != _o_.backup) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += this.activity_cfgid;
/*  90 */     _h_ += this.zone;
/*  91 */     _h_ += this.time_point_cfgid;
/*  92 */     _h_ += (int)this.start_time;
/*  93 */     _h_ += this.last_time;
/*  94 */     _h_ += this.pre_time_points.hashCode();
/*  95 */     _h_ += this.index;
/*  96 */     _h_ += this.backup;
/*  97 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 101 */     StringBuilder _sb_ = new StringBuilder();
/* 102 */     _sb_.append("(");
/* 103 */     _sb_.append(this.activity_cfgid).append(",");
/* 104 */     _sb_.append(this.zone).append(",");
/* 105 */     _sb_.append(this.time_point_cfgid).append(",");
/* 106 */     _sb_.append(this.start_time).append(",");
/* 107 */     _sb_.append(this.last_time).append(",");
/* 108 */     _sb_.append(this.pre_time_points).append(",");
/* 109 */     _sb_.append(this.index).append(",");
/* 110 */     _sb_.append(this.backup).append(",");
/* 111 */     _sb_.append(")");
/* 112 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\PointRaceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */