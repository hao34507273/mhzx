/*    */ package mzm.gsp.petarena;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class PetArenaChartData implements Marshal
/*    */ {
/*    */   public int rank;
/*    */   public long roleid;
/*    */   public Octets name;
/*    */   public int win_num;
/*    */   public int lose_num;
/*    */   public int defend_win_num;
/*    */   public int defend_lose_num;
/*    */   
/*    */   public PetArenaChartData()
/*    */   {
/* 20 */     this.name = new Octets();
/*    */   }
/*    */   
/*    */   public PetArenaChartData(int _rank_, long _roleid_, Octets _name_, int _win_num_, int _lose_num_, int _defend_win_num_, int _defend_lose_num_) {
/* 24 */     this.rank = _rank_;
/* 25 */     this.roleid = _roleid_;
/* 26 */     this.name = _name_;
/* 27 */     this.win_num = _win_num_;
/* 28 */     this.lose_num = _lose_num_;
/* 29 */     this.defend_win_num = _defend_win_num_;
/* 30 */     this.defend_lose_num = _defend_lose_num_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 34 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 38 */     _os_.marshal(this.rank);
/* 39 */     _os_.marshal(this.roleid);
/* 40 */     _os_.marshal(this.name);
/* 41 */     _os_.marshal(this.win_num);
/* 42 */     _os_.marshal(this.lose_num);
/* 43 */     _os_.marshal(this.defend_win_num);
/* 44 */     _os_.marshal(this.defend_lose_num);
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 49 */     this.rank = _os_.unmarshal_int();
/* 50 */     this.roleid = _os_.unmarshal_long();
/* 51 */     this.name = _os_.unmarshal_Octets();
/* 52 */     this.win_num = _os_.unmarshal_int();
/* 53 */     this.lose_num = _os_.unmarshal_int();
/* 54 */     this.defend_win_num = _os_.unmarshal_int();
/* 55 */     this.defend_lose_num = _os_.unmarshal_int();
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 60 */     if (_o1_ == this) return true;
/* 61 */     if ((_o1_ instanceof PetArenaChartData)) {
/* 62 */       PetArenaChartData _o_ = (PetArenaChartData)_o1_;
/* 63 */       if (this.rank != _o_.rank) return false;
/* 64 */       if (this.roleid != _o_.roleid) return false;
/* 65 */       if (!this.name.equals(_o_.name)) return false;
/* 66 */       if (this.win_num != _o_.win_num) return false;
/* 67 */       if (this.lose_num != _o_.lose_num) return false;
/* 68 */       if (this.defend_win_num != _o_.defend_win_num) return false;
/* 69 */       if (this.defend_lose_num != _o_.defend_lose_num) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.rank;
/* 78 */     _h_ += (int)this.roleid;
/* 79 */     _h_ += this.name.hashCode();
/* 80 */     _h_ += this.win_num;
/* 81 */     _h_ += this.lose_num;
/* 82 */     _h_ += this.defend_win_num;
/* 83 */     _h_ += this.defend_lose_num;
/* 84 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 88 */     StringBuilder _sb_ = new StringBuilder();
/* 89 */     _sb_.append("(");
/* 90 */     _sb_.append(this.rank).append(",");
/* 91 */     _sb_.append(this.roleid).append(",");
/* 92 */     _sb_.append("B").append(this.name.size()).append(",");
/* 93 */     _sb_.append(this.win_num).append(",");
/* 94 */     _sb_.append(this.lose_num).append(",");
/* 95 */     _sb_.append(this.defend_win_num).append(",");
/* 96 */     _sb_.append(this.defend_lose_num).append(",");
/* 97 */     _sb_.append(")");
/* 98 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\PetArenaChartData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */