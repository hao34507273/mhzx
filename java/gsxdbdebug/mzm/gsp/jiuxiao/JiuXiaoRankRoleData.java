/*    */ package mzm.gsp.jiuxiao;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class JiuXiaoRankRoleData implements Marshal
/*    */ {
/*    */   public int rank;
/*    */   public long roleid;
/*    */   public int occupation;
/*    */   public String rolename;
/*    */   public int layer;
/*    */   public int time;
/*    */   
/*    */   public JiuXiaoRankRoleData()
/*    */   {
/* 17 */     this.rolename = "";
/*    */   }
/*    */   
/*    */   public JiuXiaoRankRoleData(int _rank_, long _roleid_, int _occupation_, String _rolename_, int _layer_, int _time_) {
/* 21 */     this.rank = _rank_;
/* 22 */     this.roleid = _roleid_;
/* 23 */     this.occupation = _occupation_;
/* 24 */     this.rolename = _rolename_;
/* 25 */     this.layer = _layer_;
/* 26 */     this.time = _time_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 34 */     _os_.marshal(this.rank);
/* 35 */     _os_.marshal(this.roleid);
/* 36 */     _os_.marshal(this.occupation);
/* 37 */     _os_.marshal(this.rolename, "UTF-16LE");
/* 38 */     _os_.marshal(this.layer);
/* 39 */     _os_.marshal(this.time);
/* 40 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 44 */     this.rank = _os_.unmarshal_int();
/* 45 */     this.roleid = _os_.unmarshal_long();
/* 46 */     this.occupation = _os_.unmarshal_int();
/* 47 */     this.rolename = _os_.unmarshal_String("UTF-16LE");
/* 48 */     this.layer = _os_.unmarshal_int();
/* 49 */     this.time = _os_.unmarshal_int();
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 54 */     if (_o1_ == this) return true;
/* 55 */     if ((_o1_ instanceof JiuXiaoRankRoleData)) {
/* 56 */       JiuXiaoRankRoleData _o_ = (JiuXiaoRankRoleData)_o1_;
/* 57 */       if (this.rank != _o_.rank) return false;
/* 58 */       if (this.roleid != _o_.roleid) return false;
/* 59 */       if (this.occupation != _o_.occupation) return false;
/* 60 */       if (!this.rolename.equals(_o_.rolename)) return false;
/* 61 */       if (this.layer != _o_.layer) return false;
/* 62 */       if (this.time != _o_.time) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += this.rank;
/* 71 */     _h_ += (int)this.roleid;
/* 72 */     _h_ += this.occupation;
/* 73 */     _h_ += this.rolename.hashCode();
/* 74 */     _h_ += this.layer;
/* 75 */     _h_ += this.time;
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.rank).append(",");
/* 83 */     _sb_.append(this.roleid).append(",");
/* 84 */     _sb_.append(this.occupation).append(",");
/* 85 */     _sb_.append("T").append(this.rolename.length()).append(",");
/* 86 */     _sb_.append(this.layer).append(",");
/* 87 */     _sb_.append(this.time).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jiuxiao\JiuXiaoRankRoleData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */