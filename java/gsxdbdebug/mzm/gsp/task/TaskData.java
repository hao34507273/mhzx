/*    */ package mzm.gsp.task;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class TaskData implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int graphid;
/*    */   public int taskid;
/*    */   public int state;
/*    */   public ArrayList<ConData> condatas;
/*    */   public ArrayList<Integer> uncondatas;
/*    */   
/*    */   public TaskData()
/*    */   {
/* 16 */     this.condatas = new ArrayList();
/* 17 */     this.uncondatas = new ArrayList();
/*    */   }
/*    */   
/*    */   public TaskData(int _graphid_, int _taskid_, int _state_, ArrayList<ConData> _condatas_, ArrayList<Integer> _uncondatas_) {
/* 21 */     this.graphid = _graphid_;
/* 22 */     this.taskid = _taskid_;
/* 23 */     this.state = _state_;
/* 24 */     this.condatas = _condatas_;
/* 25 */     this.uncondatas = _uncondatas_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 29 */     for (ConData _v_ : this.condatas)
/* 30 */       if (!_v_._validator_()) return false;
/* 31 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 35 */     _os_.marshal(this.graphid);
/* 36 */     _os_.marshal(this.taskid);
/* 37 */     _os_.marshal(this.state);
/* 38 */     _os_.compact_uint32(this.condatas.size());
/* 39 */     for (ConData _v_ : this.condatas) {
/* 40 */       _os_.marshal(_v_);
/*    */     }
/* 42 */     _os_.compact_uint32(this.uncondatas.size());
/* 43 */     for (Integer _v_ : this.uncondatas) {
/* 44 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 50 */     this.graphid = _os_.unmarshal_int();
/* 51 */     this.taskid = _os_.unmarshal_int();
/* 52 */     this.state = _os_.unmarshal_int();
/* 53 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 54 */       ConData _v_ = new ConData();
/* 55 */       _v_.unmarshal(_os_);
/* 56 */       this.condatas.add(_v_);
/*    */     }
/* 58 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 60 */       int _v_ = _os_.unmarshal_int();
/* 61 */       this.uncondatas.add(Integer.valueOf(_v_));
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof TaskData)) {
/* 69 */       TaskData _o_ = (TaskData)_o1_;
/* 70 */       if (this.graphid != _o_.graphid) return false;
/* 71 */       if (this.taskid != _o_.taskid) return false;
/* 72 */       if (this.state != _o_.state) return false;
/* 73 */       if (!this.condatas.equals(_o_.condatas)) return false;
/* 74 */       if (!this.uncondatas.equals(_o_.uncondatas)) return false;
/* 75 */       return true;
/*    */     }
/* 77 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 81 */     int _h_ = 0;
/* 82 */     _h_ += this.graphid;
/* 83 */     _h_ += this.taskid;
/* 84 */     _h_ += this.state;
/* 85 */     _h_ += this.condatas.hashCode();
/* 86 */     _h_ += this.uncondatas.hashCode();
/* 87 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 91 */     StringBuilder _sb_ = new StringBuilder();
/* 92 */     _sb_.append("(");
/* 93 */     _sb_.append(this.graphid).append(",");
/* 94 */     _sb_.append(this.taskid).append(",");
/* 95 */     _sb_.append(this.state).append(",");
/* 96 */     _sb_.append(this.condatas).append(",");
/* 97 */     _sb_.append(this.uncondatas).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\TaskData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */