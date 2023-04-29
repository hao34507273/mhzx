/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ 
/*      */ public final class ShiTuTaskInfo extends XBean implements xbean.ShiTuTaskInfo
/*      */ {
/*      */   private long reset_time;
/*      */   private int publish_state;
/*      */   private int refresh_times;
/*      */   private int shitu_task_count;
/*      */   private HashMap<Integer, xbean.ShiTuTask> task_infos;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   26 */     this.reset_time = 0L;
/*   27 */     this.publish_state = 0;
/*   28 */     this.refresh_times = 0;
/*   29 */     this.shitu_task_count = 0;
/*   30 */     this.task_infos.clear();
/*      */   }
/*      */   
/*      */   ShiTuTaskInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   35 */     super(_xp_, _vn_);
/*   36 */     this.task_infos = new HashMap();
/*      */   }
/*      */   
/*      */   public ShiTuTaskInfo()
/*      */   {
/*   41 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public ShiTuTaskInfo(ShiTuTaskInfo _o_)
/*      */   {
/*   46 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   ShiTuTaskInfo(xbean.ShiTuTaskInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   51 */     super(_xp_, _vn_);
/*   52 */     if ((_o1_ instanceof ShiTuTaskInfo)) { assign((ShiTuTaskInfo)_o1_);
/*   53 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   54 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   55 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(ShiTuTaskInfo _o_) {
/*   60 */     _o_._xdb_verify_unsafe_();
/*   61 */     this.reset_time = _o_.reset_time;
/*   62 */     this.publish_state = _o_.publish_state;
/*   63 */     this.refresh_times = _o_.refresh_times;
/*   64 */     this.shitu_task_count = _o_.shitu_task_count;
/*   65 */     this.task_infos = new HashMap();
/*   66 */     for (Map.Entry<Integer, xbean.ShiTuTask> _e_ : _o_.task_infos.entrySet()) {
/*   67 */       this.task_infos.put(_e_.getKey(), new ShiTuTask((xbean.ShiTuTask)_e_.getValue(), this, "task_infos"));
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*   72 */     this.reset_time = _o_.reset_time;
/*   73 */     this.publish_state = _o_.publish_state;
/*   74 */     this.refresh_times = _o_.refresh_times;
/*   75 */     this.shitu_task_count = _o_.shitu_task_count;
/*   76 */     this.task_infos = new HashMap();
/*   77 */     for (Map.Entry<Integer, xbean.ShiTuTask> _e_ : _o_.task_infos.entrySet()) {
/*   78 */       this.task_infos.put(_e_.getKey(), new ShiTuTask((xbean.ShiTuTask)_e_.getValue(), this, "task_infos"));
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   84 */     _xdb_verify_unsafe_();
/*   85 */     _os_.marshal(this.reset_time);
/*   86 */     _os_.marshal(this.publish_state);
/*   87 */     _os_.marshal(this.refresh_times);
/*   88 */     _os_.marshal(this.shitu_task_count);
/*   89 */     _os_.compact_uint32(this.task_infos.size());
/*   90 */     for (Map.Entry<Integer, xbean.ShiTuTask> _e_ : this.task_infos.entrySet())
/*      */     {
/*   92 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*   93 */       ((xbean.ShiTuTask)_e_.getValue()).marshal(_os_);
/*      */     }
/*   95 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  101 */     _xdb_verify_unsafe_();
/*  102 */     this.reset_time = _os_.unmarshal_long();
/*  103 */     this.publish_state = _os_.unmarshal_int();
/*  104 */     this.refresh_times = _os_.unmarshal_int();
/*  105 */     this.shitu_task_count = _os_.unmarshal_int();
/*      */     
/*  107 */     int size = _os_.uncompact_uint32();
/*  108 */     if (size >= 12)
/*      */     {
/*  110 */       this.task_infos = new HashMap(size * 2);
/*      */     }
/*  112 */     for (; size > 0; size--)
/*      */     {
/*  114 */       int _k_ = 0;
/*  115 */       _k_ = _os_.unmarshal_int();
/*  116 */       xbean.ShiTuTask _v_ = new ShiTuTask(0, this, "task_infos");
/*  117 */       _v_.unmarshal(_os_);
/*  118 */       this.task_infos.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  121 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  127 */     _xdb_verify_unsafe_();
/*  128 */     int _size_ = 0;
/*  129 */     _size_ += CodedOutputStream.computeInt64Size(1, this.reset_time);
/*  130 */     _size_ += CodedOutputStream.computeInt32Size(2, this.publish_state);
/*  131 */     _size_ += CodedOutputStream.computeInt32Size(3, this.refresh_times);
/*  132 */     _size_ += CodedOutputStream.computeInt32Size(4, this.shitu_task_count);
/*  133 */     for (Map.Entry<Integer, xbean.ShiTuTask> _e_ : this.task_infos.entrySet())
/*      */     {
/*  135 */       _size_ += CodedOutputStream.computeInt32Size(5, ((Integer)_e_.getKey()).intValue());
/*  136 */       _size_ += CodedOutputStream.computeMessageSize(5, (ppbio.Message)_e_.getValue());
/*      */     }
/*  138 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  144 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  147 */       _output_.writeInt64(1, this.reset_time);
/*  148 */       _output_.writeInt32(2, this.publish_state);
/*  149 */       _output_.writeInt32(3, this.refresh_times);
/*  150 */       _output_.writeInt32(4, this.shitu_task_count);
/*  151 */       for (Map.Entry<Integer, xbean.ShiTuTask> _e_ : this.task_infos.entrySet())
/*      */       {
/*  153 */         _output_.writeInt32(5, ((Integer)_e_.getKey()).intValue());
/*  154 */         _output_.writeMessage(5, (ppbio.Message)_e_.getValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  159 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  161 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  167 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  170 */       boolean done = false;
/*  171 */       while (!done)
/*      */       {
/*  173 */         int tag = _input_.readTag();
/*  174 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  178 */           done = true;
/*  179 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  183 */           this.reset_time = _input_.readInt64();
/*  184 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  188 */           this.publish_state = _input_.readInt32();
/*  189 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  193 */           this.refresh_times = _input_.readInt32();
/*  194 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  198 */           this.shitu_task_count = _input_.readInt32();
/*  199 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  203 */           int _k_ = 0;
/*  204 */           _k_ = _input_.readInt32();
/*  205 */           int readTag = _input_.readTag();
/*  206 */           if (42 != readTag)
/*      */           {
/*  208 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  210 */           xbean.ShiTuTask _v_ = new ShiTuTask(0, this, "task_infos");
/*  211 */           _input_.readMessage(_v_);
/*  212 */           this.task_infos.put(Integer.valueOf(_k_), _v_);
/*  213 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  217 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  219 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  228 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  232 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  234 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.ShiTuTaskInfo copy()
/*      */   {
/*  240 */     _xdb_verify_unsafe_();
/*  241 */     return new ShiTuTaskInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.ShiTuTaskInfo toData()
/*      */   {
/*  247 */     _xdb_verify_unsafe_();
/*  248 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.ShiTuTaskInfo toBean()
/*      */   {
/*  253 */     _xdb_verify_unsafe_();
/*  254 */     return new ShiTuTaskInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.ShiTuTaskInfo toDataIf()
/*      */   {
/*  260 */     _xdb_verify_unsafe_();
/*  261 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.ShiTuTaskInfo toBeanIf()
/*      */   {
/*  266 */     _xdb_verify_unsafe_();
/*  267 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  273 */     _xdb_verify_unsafe_();
/*  274 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getReset_time()
/*      */   {
/*  281 */     _xdb_verify_unsafe_();
/*  282 */     return this.reset_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPublish_state()
/*      */   {
/*  289 */     _xdb_verify_unsafe_();
/*  290 */     return this.publish_state;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getRefresh_times()
/*      */   {
/*  297 */     _xdb_verify_unsafe_();
/*  298 */     return this.refresh_times;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getShitu_task_count()
/*      */   {
/*  305 */     _xdb_verify_unsafe_();
/*  306 */     return this.shitu_task_count;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.ShiTuTask> getTask_infos()
/*      */   {
/*  313 */     _xdb_verify_unsafe_();
/*  314 */     return xdb.Logs.logMap(new LogKey(this, "task_infos"), this.task_infos);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.ShiTuTask> getTask_infosAsData()
/*      */   {
/*  321 */     _xdb_verify_unsafe_();
/*      */     
/*  323 */     ShiTuTaskInfo _o_ = this;
/*  324 */     Map<Integer, xbean.ShiTuTask> task_infos = new HashMap();
/*  325 */     for (Map.Entry<Integer, xbean.ShiTuTask> _e_ : _o_.task_infos.entrySet())
/*  326 */       task_infos.put(_e_.getKey(), new ShiTuTask.Data((xbean.ShiTuTask)_e_.getValue()));
/*  327 */     return task_infos;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setReset_time(long _v_)
/*      */   {
/*  334 */     _xdb_verify_unsafe_();
/*  335 */     xdb.Logs.logIf(new LogKey(this, "reset_time")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  339 */         new xdb.logs.LogLong(this, ShiTuTaskInfo.this.reset_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  343 */             ShiTuTaskInfo.this.reset_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  347 */     });
/*  348 */     this.reset_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPublish_state(int _v_)
/*      */   {
/*  355 */     _xdb_verify_unsafe_();
/*  356 */     xdb.Logs.logIf(new LogKey(this, "publish_state")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  360 */         new xdb.logs.LogInt(this, ShiTuTaskInfo.this.publish_state)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  364 */             ShiTuTaskInfo.this.publish_state = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  368 */     });
/*  369 */     this.publish_state = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRefresh_times(int _v_)
/*      */   {
/*  376 */     _xdb_verify_unsafe_();
/*  377 */     xdb.Logs.logIf(new LogKey(this, "refresh_times")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  381 */         new xdb.logs.LogInt(this, ShiTuTaskInfo.this.refresh_times)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  385 */             ShiTuTaskInfo.this.refresh_times = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  389 */     });
/*  390 */     this.refresh_times = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setShitu_task_count(int _v_)
/*      */   {
/*  397 */     _xdb_verify_unsafe_();
/*  398 */     xdb.Logs.logIf(new LogKey(this, "shitu_task_count")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  402 */         new xdb.logs.LogInt(this, ShiTuTaskInfo.this.shitu_task_count)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  406 */             ShiTuTaskInfo.this.shitu_task_count = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  410 */     });
/*  411 */     this.shitu_task_count = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  417 */     _xdb_verify_unsafe_();
/*  418 */     ShiTuTaskInfo _o_ = null;
/*  419 */     if ((_o1_ instanceof ShiTuTaskInfo)) { _o_ = (ShiTuTaskInfo)_o1_;
/*  420 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  421 */       return false;
/*  422 */     if (this.reset_time != _o_.reset_time) return false;
/*  423 */     if (this.publish_state != _o_.publish_state) return false;
/*  424 */     if (this.refresh_times != _o_.refresh_times) return false;
/*  425 */     if (this.shitu_task_count != _o_.shitu_task_count) return false;
/*  426 */     if (!this.task_infos.equals(_o_.task_infos)) return false;
/*  427 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  433 */     _xdb_verify_unsafe_();
/*  434 */     int _h_ = 0;
/*  435 */     _h_ = (int)(_h_ + this.reset_time);
/*  436 */     _h_ += this.publish_state;
/*  437 */     _h_ += this.refresh_times;
/*  438 */     _h_ += this.shitu_task_count;
/*  439 */     _h_ += this.task_infos.hashCode();
/*  440 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  446 */     _xdb_verify_unsafe_();
/*  447 */     StringBuilder _sb_ = new StringBuilder();
/*  448 */     _sb_.append("(");
/*  449 */     _sb_.append(this.reset_time);
/*  450 */     _sb_.append(",");
/*  451 */     _sb_.append(this.publish_state);
/*  452 */     _sb_.append(",");
/*  453 */     _sb_.append(this.refresh_times);
/*  454 */     _sb_.append(",");
/*  455 */     _sb_.append(this.shitu_task_count);
/*  456 */     _sb_.append(",");
/*  457 */     _sb_.append(this.task_infos);
/*  458 */     _sb_.append(")");
/*  459 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  465 */     ListenableBean lb = new ListenableBean();
/*  466 */     lb.add(new ListenableChanged().setVarName("reset_time"));
/*  467 */     lb.add(new ListenableChanged().setVarName("publish_state"));
/*  468 */     lb.add(new ListenableChanged().setVarName("refresh_times"));
/*  469 */     lb.add(new ListenableChanged().setVarName("shitu_task_count"));
/*  470 */     lb.add(new xdb.logs.ListenableMap().setVarName("task_infos"));
/*  471 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.ShiTuTaskInfo {
/*      */     private Const() {}
/*      */     
/*      */     ShiTuTaskInfo nThis() {
/*  478 */       return ShiTuTaskInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  484 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ShiTuTaskInfo copy()
/*      */     {
/*  490 */       return ShiTuTaskInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ShiTuTaskInfo toData()
/*      */     {
/*  496 */       return ShiTuTaskInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.ShiTuTaskInfo toBean()
/*      */     {
/*  501 */       return ShiTuTaskInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ShiTuTaskInfo toDataIf()
/*      */     {
/*  507 */       return ShiTuTaskInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.ShiTuTaskInfo toBeanIf()
/*      */     {
/*  512 */       return ShiTuTaskInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getReset_time()
/*      */     {
/*  519 */       ShiTuTaskInfo.this._xdb_verify_unsafe_();
/*  520 */       return ShiTuTaskInfo.this.reset_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPublish_state()
/*      */     {
/*  527 */       ShiTuTaskInfo.this._xdb_verify_unsafe_();
/*  528 */       return ShiTuTaskInfo.this.publish_state;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRefresh_times()
/*      */     {
/*  535 */       ShiTuTaskInfo.this._xdb_verify_unsafe_();
/*  536 */       return ShiTuTaskInfo.this.refresh_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getShitu_task_count()
/*      */     {
/*  543 */       ShiTuTaskInfo.this._xdb_verify_unsafe_();
/*  544 */       return ShiTuTaskInfo.this.shitu_task_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.ShiTuTask> getTask_infos()
/*      */     {
/*  551 */       ShiTuTaskInfo.this._xdb_verify_unsafe_();
/*  552 */       return xdb.Consts.constMap(ShiTuTaskInfo.this.task_infos);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.ShiTuTask> getTask_infosAsData()
/*      */     {
/*  559 */       ShiTuTaskInfo.this._xdb_verify_unsafe_();
/*      */       
/*  561 */       ShiTuTaskInfo _o_ = ShiTuTaskInfo.this;
/*  562 */       Map<Integer, xbean.ShiTuTask> task_infos = new HashMap();
/*  563 */       for (Map.Entry<Integer, xbean.ShiTuTask> _e_ : _o_.task_infos.entrySet())
/*  564 */         task_infos.put(_e_.getKey(), new ShiTuTask.Data((xbean.ShiTuTask)_e_.getValue()));
/*  565 */       return task_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setReset_time(long _v_)
/*      */     {
/*  572 */       ShiTuTaskInfo.this._xdb_verify_unsafe_();
/*  573 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPublish_state(int _v_)
/*      */     {
/*  580 */       ShiTuTaskInfo.this._xdb_verify_unsafe_();
/*  581 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRefresh_times(int _v_)
/*      */     {
/*  588 */       ShiTuTaskInfo.this._xdb_verify_unsafe_();
/*  589 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setShitu_task_count(int _v_)
/*      */     {
/*  596 */       ShiTuTaskInfo.this._xdb_verify_unsafe_();
/*  597 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  603 */       ShiTuTaskInfo.this._xdb_verify_unsafe_();
/*  604 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  610 */       ShiTuTaskInfo.this._xdb_verify_unsafe_();
/*  611 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  617 */       return ShiTuTaskInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  623 */       return ShiTuTaskInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  629 */       ShiTuTaskInfo.this._xdb_verify_unsafe_();
/*  630 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  636 */       return ShiTuTaskInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  642 */       return ShiTuTaskInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  648 */       ShiTuTaskInfo.this._xdb_verify_unsafe_();
/*  649 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  655 */       return ShiTuTaskInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  661 */       return ShiTuTaskInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  667 */       return ShiTuTaskInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  673 */       return ShiTuTaskInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  679 */       return ShiTuTaskInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  685 */       return ShiTuTaskInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  691 */       return ShiTuTaskInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.ShiTuTaskInfo
/*      */   {
/*      */     private long reset_time;
/*      */     
/*      */     private int publish_state;
/*      */     
/*      */     private int refresh_times;
/*      */     
/*      */     private int shitu_task_count;
/*      */     
/*      */     private HashMap<Integer, xbean.ShiTuTask> task_infos;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  711 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  716 */       this.task_infos = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.ShiTuTaskInfo _o1_)
/*      */     {
/*  721 */       if ((_o1_ instanceof ShiTuTaskInfo)) { assign((ShiTuTaskInfo)_o1_);
/*  722 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  723 */       } else if ((_o1_ instanceof ShiTuTaskInfo.Const)) assign(((ShiTuTaskInfo.Const)_o1_).nThis()); else {
/*  724 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(ShiTuTaskInfo _o_) {
/*  729 */       this.reset_time = _o_.reset_time;
/*  730 */       this.publish_state = _o_.publish_state;
/*  731 */       this.refresh_times = _o_.refresh_times;
/*  732 */       this.shitu_task_count = _o_.shitu_task_count;
/*  733 */       this.task_infos = new HashMap();
/*  734 */       for (Map.Entry<Integer, xbean.ShiTuTask> _e_ : _o_.task_infos.entrySet()) {
/*  735 */         this.task_infos.put(_e_.getKey(), new ShiTuTask.Data((xbean.ShiTuTask)_e_.getValue()));
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/*  740 */       this.reset_time = _o_.reset_time;
/*  741 */       this.publish_state = _o_.publish_state;
/*  742 */       this.refresh_times = _o_.refresh_times;
/*  743 */       this.shitu_task_count = _o_.shitu_task_count;
/*  744 */       this.task_infos = new HashMap();
/*  745 */       for (Map.Entry<Integer, xbean.ShiTuTask> _e_ : _o_.task_infos.entrySet()) {
/*  746 */         this.task_infos.put(_e_.getKey(), new ShiTuTask.Data((xbean.ShiTuTask)_e_.getValue()));
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  752 */       _os_.marshal(this.reset_time);
/*  753 */       _os_.marshal(this.publish_state);
/*  754 */       _os_.marshal(this.refresh_times);
/*  755 */       _os_.marshal(this.shitu_task_count);
/*  756 */       _os_.compact_uint32(this.task_infos.size());
/*  757 */       for (Map.Entry<Integer, xbean.ShiTuTask> _e_ : this.task_infos.entrySet())
/*      */       {
/*  759 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  760 */         ((xbean.ShiTuTask)_e_.getValue()).marshal(_os_);
/*      */       }
/*  762 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  768 */       this.reset_time = _os_.unmarshal_long();
/*  769 */       this.publish_state = _os_.unmarshal_int();
/*  770 */       this.refresh_times = _os_.unmarshal_int();
/*  771 */       this.shitu_task_count = _os_.unmarshal_int();
/*      */       
/*  773 */       int size = _os_.uncompact_uint32();
/*  774 */       if (size >= 12)
/*      */       {
/*  776 */         this.task_infos = new HashMap(size * 2);
/*      */       }
/*  778 */       for (; size > 0; size--)
/*      */       {
/*  780 */         int _k_ = 0;
/*  781 */         _k_ = _os_.unmarshal_int();
/*  782 */         xbean.ShiTuTask _v_ = xbean.Pod.newShiTuTaskData();
/*  783 */         _v_.unmarshal(_os_);
/*  784 */         this.task_infos.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*  787 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  793 */       int _size_ = 0;
/*  794 */       _size_ += CodedOutputStream.computeInt64Size(1, this.reset_time);
/*  795 */       _size_ += CodedOutputStream.computeInt32Size(2, this.publish_state);
/*  796 */       _size_ += CodedOutputStream.computeInt32Size(3, this.refresh_times);
/*  797 */       _size_ += CodedOutputStream.computeInt32Size(4, this.shitu_task_count);
/*  798 */       for (Map.Entry<Integer, xbean.ShiTuTask> _e_ : this.task_infos.entrySet())
/*      */       {
/*  800 */         _size_ += CodedOutputStream.computeInt32Size(5, ((Integer)_e_.getKey()).intValue());
/*  801 */         _size_ += CodedOutputStream.computeMessageSize(5, (ppbio.Message)_e_.getValue());
/*      */       }
/*  803 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  811 */         _output_.writeInt64(1, this.reset_time);
/*  812 */         _output_.writeInt32(2, this.publish_state);
/*  813 */         _output_.writeInt32(3, this.refresh_times);
/*  814 */         _output_.writeInt32(4, this.shitu_task_count);
/*  815 */         for (Map.Entry<Integer, xbean.ShiTuTask> _e_ : this.task_infos.entrySet())
/*      */         {
/*  817 */           _output_.writeInt32(5, ((Integer)_e_.getKey()).intValue());
/*  818 */           _output_.writeMessage(5, (ppbio.Message)_e_.getValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  823 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  825 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  833 */         boolean done = false;
/*  834 */         while (!done)
/*      */         {
/*  836 */           int tag = _input_.readTag();
/*  837 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  841 */             done = true;
/*  842 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  846 */             this.reset_time = _input_.readInt64();
/*  847 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  851 */             this.publish_state = _input_.readInt32();
/*  852 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  856 */             this.refresh_times = _input_.readInt32();
/*  857 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  861 */             this.shitu_task_count = _input_.readInt32();
/*  862 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  866 */             int _k_ = 0;
/*  867 */             _k_ = _input_.readInt32();
/*  868 */             int readTag = _input_.readTag();
/*  869 */             if (42 != readTag)
/*      */             {
/*  871 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  873 */             xbean.ShiTuTask _v_ = xbean.Pod.newShiTuTaskData();
/*  874 */             _input_.readMessage(_v_);
/*  875 */             this.task_infos.put(Integer.valueOf(_k_), _v_);
/*  876 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  880 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  882 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  891 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  895 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  897 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ShiTuTaskInfo copy()
/*      */     {
/*  903 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ShiTuTaskInfo toData()
/*      */     {
/*  909 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.ShiTuTaskInfo toBean()
/*      */     {
/*  914 */       return new ShiTuTaskInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ShiTuTaskInfo toDataIf()
/*      */     {
/*  920 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.ShiTuTaskInfo toBeanIf()
/*      */     {
/*  925 */       return new ShiTuTaskInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  931 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  935 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  939 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  943 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  947 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  951 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  955 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getReset_time()
/*      */     {
/*  962 */       return this.reset_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPublish_state()
/*      */     {
/*  969 */       return this.publish_state;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRefresh_times()
/*      */     {
/*  976 */       return this.refresh_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getShitu_task_count()
/*      */     {
/*  983 */       return this.shitu_task_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.ShiTuTask> getTask_infos()
/*      */     {
/*  990 */       return this.task_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.ShiTuTask> getTask_infosAsData()
/*      */     {
/*  997 */       return this.task_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setReset_time(long _v_)
/*      */     {
/* 1004 */       this.reset_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPublish_state(int _v_)
/*      */     {
/* 1011 */       this.publish_state = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRefresh_times(int _v_)
/*      */     {
/* 1018 */       this.refresh_times = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setShitu_task_count(int _v_)
/*      */     {
/* 1025 */       this.shitu_task_count = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1031 */       if (!(_o1_ instanceof Data)) return false;
/* 1032 */       Data _o_ = (Data)_o1_;
/* 1033 */       if (this.reset_time != _o_.reset_time) return false;
/* 1034 */       if (this.publish_state != _o_.publish_state) return false;
/* 1035 */       if (this.refresh_times != _o_.refresh_times) return false;
/* 1036 */       if (this.shitu_task_count != _o_.shitu_task_count) return false;
/* 1037 */       if (!this.task_infos.equals(_o_.task_infos)) return false;
/* 1038 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1044 */       int _h_ = 0;
/* 1045 */       _h_ = (int)(_h_ + this.reset_time);
/* 1046 */       _h_ += this.publish_state;
/* 1047 */       _h_ += this.refresh_times;
/* 1048 */       _h_ += this.shitu_task_count;
/* 1049 */       _h_ += this.task_infos.hashCode();
/* 1050 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1056 */       StringBuilder _sb_ = new StringBuilder();
/* 1057 */       _sb_.append("(");
/* 1058 */       _sb_.append(this.reset_time);
/* 1059 */       _sb_.append(",");
/* 1060 */       _sb_.append(this.publish_state);
/* 1061 */       _sb_.append(",");
/* 1062 */       _sb_.append(this.refresh_times);
/* 1063 */       _sb_.append(",");
/* 1064 */       _sb_.append(this.shitu_task_count);
/* 1065 */       _sb_.append(",");
/* 1066 */       _sb_.append(this.task_infos);
/* 1067 */       _sb_.append(")");
/* 1068 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ShiTuTaskInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */