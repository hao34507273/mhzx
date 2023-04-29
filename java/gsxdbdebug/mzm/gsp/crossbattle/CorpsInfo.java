/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class CorpsInfo implements Marshal
/*    */ {
/*    */   public long corps_id;
/*    */   public int zone_id;
/*    */   public Octets corps_name;
/*    */   public int corps_icon;
/*    */   public int corps_rank;
/*    */   
/*    */   public CorpsInfo()
/*    */   {
/* 18 */     this.corps_name = new Octets();
/*    */   }
/*    */   
/*    */   public CorpsInfo(long _corps_id_, int _zone_id_, Octets _corps_name_, int _corps_icon_, int _corps_rank_) {
/* 22 */     this.corps_id = _corps_id_;
/* 23 */     this.zone_id = _zone_id_;
/* 24 */     this.corps_name = _corps_name_;
/* 25 */     this.corps_icon = _corps_icon_;
/* 26 */     this.corps_rank = _corps_rank_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 34 */     _os_.marshal(this.corps_id);
/* 35 */     _os_.marshal(this.zone_id);
/* 36 */     _os_.marshal(this.corps_name);
/* 37 */     _os_.marshal(this.corps_icon);
/* 38 */     _os_.marshal(this.corps_rank);
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 43 */     this.corps_id = _os_.unmarshal_long();
/* 44 */     this.zone_id = _os_.unmarshal_int();
/* 45 */     this.corps_name = _os_.unmarshal_Octets();
/* 46 */     this.corps_icon = _os_.unmarshal_int();
/* 47 */     this.corps_rank = _os_.unmarshal_int();
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 52 */     if (_o1_ == this) return true;
/* 53 */     if ((_o1_ instanceof CorpsInfo)) {
/* 54 */       CorpsInfo _o_ = (CorpsInfo)_o1_;
/* 55 */       if (this.corps_id != _o_.corps_id) return false;
/* 56 */       if (this.zone_id != _o_.zone_id) return false;
/* 57 */       if (!this.corps_name.equals(_o_.corps_name)) return false;
/* 58 */       if (this.corps_icon != _o_.corps_icon) return false;
/* 59 */       if (this.corps_rank != _o_.corps_rank) return false;
/* 60 */       return true;
/*    */     }
/* 62 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 66 */     int _h_ = 0;
/* 67 */     _h_ += (int)this.corps_id;
/* 68 */     _h_ += this.zone_id;
/* 69 */     _h_ += this.corps_name.hashCode();
/* 70 */     _h_ += this.corps_icon;
/* 71 */     _h_ += this.corps_rank;
/* 72 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 76 */     StringBuilder _sb_ = new StringBuilder();
/* 77 */     _sb_.append("(");
/* 78 */     _sb_.append(this.corps_id).append(",");
/* 79 */     _sb_.append(this.zone_id).append(",");
/* 80 */     _sb_.append("B").append(this.corps_name.size()).append(",");
/* 81 */     _sb_.append(this.corps_icon).append(",");
/* 82 */     _sb_.append(this.corps_rank).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\CorpsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */