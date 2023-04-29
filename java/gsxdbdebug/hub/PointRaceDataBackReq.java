/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class PointRaceDataBackReq implements Marshal
/*    */ {
/*    */   public ArrayList<PointRaceUserDataBack> user_back_datas;
/*    */   public int activity_cfgid;
/*    */   public int time_point_cfgid;
/*    */   public PointRaceCorpsInfo corps_info;
/*    */   public int pvp_fight;
/*    */   
/*    */   public PointRaceDataBackReq()
/*    */   {
/* 18 */     this.user_back_datas = new ArrayList();
/* 19 */     this.corps_info = new PointRaceCorpsInfo();
/*    */   }
/*    */   
/*    */   public PointRaceDataBackReq(ArrayList<PointRaceUserDataBack> _user_back_datas_, int _activity_cfgid_, int _time_point_cfgid_, PointRaceCorpsInfo _corps_info_, int _pvp_fight_) {
/* 23 */     this.user_back_datas = _user_back_datas_;
/* 24 */     this.activity_cfgid = _activity_cfgid_;
/* 25 */     this.time_point_cfgid = _time_point_cfgid_;
/* 26 */     this.corps_info = _corps_info_;
/* 27 */     this.pvp_fight = _pvp_fight_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 31 */     for (PointRaceUserDataBack _v_ : this.user_back_datas)
/* 32 */       if (!_v_._validator_()) return false;
/* 33 */     if (!this.corps_info._validator_()) return false;
/* 34 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 38 */     _os_.compact_uint32(this.user_back_datas.size());
/* 39 */     for (PointRaceUserDataBack _v_ : this.user_back_datas) {
/* 40 */       _os_.marshal(_v_);
/*    */     }
/* 42 */     _os_.marshal(this.activity_cfgid);
/* 43 */     _os_.marshal(this.time_point_cfgid);
/* 44 */     _os_.marshal(this.corps_info);
/* 45 */     _os_.marshal(this.pvp_fight);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 51 */       PointRaceUserDataBack _v_ = new PointRaceUserDataBack();
/* 52 */       _v_.unmarshal(_os_);
/* 53 */       this.user_back_datas.add(_v_);
/*    */     }
/* 55 */     this.activity_cfgid = _os_.unmarshal_int();
/* 56 */     this.time_point_cfgid = _os_.unmarshal_int();
/* 57 */     this.corps_info.unmarshal(_os_);
/* 58 */     this.pvp_fight = _os_.unmarshal_int();
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof PointRaceDataBackReq)) {
/* 65 */       PointRaceDataBackReq _o_ = (PointRaceDataBackReq)_o1_;
/* 66 */       if (!this.user_back_datas.equals(_o_.user_back_datas)) return false;
/* 67 */       if (this.activity_cfgid != _o_.activity_cfgid) return false;
/* 68 */       if (this.time_point_cfgid != _o_.time_point_cfgid) return false;
/* 69 */       if (!this.corps_info.equals(_o_.corps_info)) return false;
/* 70 */       if (this.pvp_fight != _o_.pvp_fight) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.user_back_datas.hashCode();
/* 79 */     _h_ += this.activity_cfgid;
/* 80 */     _h_ += this.time_point_cfgid;
/* 81 */     _h_ += this.corps_info.hashCode();
/* 82 */     _h_ += this.pvp_fight;
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.user_back_datas).append(",");
/* 90 */     _sb_.append(this.activity_cfgid).append(",");
/* 91 */     _sb_.append(this.time_point_cfgid).append(",");
/* 92 */     _sb_.append(this.corps_info).append(",");
/* 93 */     _sb_.append(this.pvp_fight).append(",");
/* 94 */     _sb_.append(")");
/* 95 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\PointRaceDataBackReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */