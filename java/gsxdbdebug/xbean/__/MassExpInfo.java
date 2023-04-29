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
/*      */ public final class MassExpInfo extends XBean implements xbean.MassExpInfo
/*      */ {
/*      */   private int status;
/*      */   private int cur_index;
/*      */   private long start_time;
/*      */   private HashMap<Integer, xbean.FillGridInfo> costs;
/*      */   private long end_time;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   26 */     this.status = 0;
/*   27 */     this.cur_index = 0;
/*   28 */     this.start_time = 0L;
/*   29 */     this.costs.clear();
/*   30 */     this.end_time = 0L;
/*      */   }
/*      */   
/*      */   MassExpInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   35 */     super(_xp_, _vn_);
/*   36 */     this.costs = new HashMap();
/*      */   }
/*      */   
/*      */   public MassExpInfo()
/*      */   {
/*   41 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public MassExpInfo(MassExpInfo _o_)
/*      */   {
/*   46 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   MassExpInfo(xbean.MassExpInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   51 */     super(_xp_, _vn_);
/*   52 */     if ((_o1_ instanceof MassExpInfo)) { assign((MassExpInfo)_o1_);
/*   53 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   54 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   55 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(MassExpInfo _o_) {
/*   60 */     _o_._xdb_verify_unsafe_();
/*   61 */     this.status = _o_.status;
/*   62 */     this.cur_index = _o_.cur_index;
/*   63 */     this.start_time = _o_.start_time;
/*   64 */     this.costs = new HashMap();
/*   65 */     for (Map.Entry<Integer, xbean.FillGridInfo> _e_ : _o_.costs.entrySet())
/*   66 */       this.costs.put(_e_.getKey(), new FillGridInfo((xbean.FillGridInfo)_e_.getValue(), this, "costs"));
/*   67 */     this.end_time = _o_.end_time;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   72 */     this.status = _o_.status;
/*   73 */     this.cur_index = _o_.cur_index;
/*   74 */     this.start_time = _o_.start_time;
/*   75 */     this.costs = new HashMap();
/*   76 */     for (Map.Entry<Integer, xbean.FillGridInfo> _e_ : _o_.costs.entrySet())
/*   77 */       this.costs.put(_e_.getKey(), new FillGridInfo((xbean.FillGridInfo)_e_.getValue(), this, "costs"));
/*   78 */     this.end_time = _o_.end_time;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   84 */     _xdb_verify_unsafe_();
/*   85 */     _os_.marshal(this.status);
/*   86 */     _os_.marshal(this.cur_index);
/*   87 */     _os_.marshal(this.start_time);
/*   88 */     _os_.compact_uint32(this.costs.size());
/*   89 */     for (Map.Entry<Integer, xbean.FillGridInfo> _e_ : this.costs.entrySet())
/*      */     {
/*   91 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*   92 */       ((xbean.FillGridInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*   94 */     _os_.marshal(this.end_time);
/*   95 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  101 */     _xdb_verify_unsafe_();
/*  102 */     this.status = _os_.unmarshal_int();
/*  103 */     this.cur_index = _os_.unmarshal_int();
/*  104 */     this.start_time = _os_.unmarshal_long();
/*      */     
/*  106 */     int size = _os_.uncompact_uint32();
/*  107 */     if (size >= 12)
/*      */     {
/*  109 */       this.costs = new HashMap(size * 2);
/*      */     }
/*  111 */     for (; size > 0; size--)
/*      */     {
/*  113 */       int _k_ = 0;
/*  114 */       _k_ = _os_.unmarshal_int();
/*  115 */       xbean.FillGridInfo _v_ = new FillGridInfo(0, this, "costs");
/*  116 */       _v_.unmarshal(_os_);
/*  117 */       this.costs.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  120 */     this.end_time = _os_.unmarshal_long();
/*  121 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  127 */     _xdb_verify_unsafe_();
/*  128 */     int _size_ = 0;
/*  129 */     _size_ += CodedOutputStream.computeInt32Size(1, this.status);
/*  130 */     _size_ += CodedOutputStream.computeInt32Size(2, this.cur_index);
/*  131 */     _size_ += CodedOutputStream.computeInt64Size(3, this.start_time);
/*  132 */     for (Map.Entry<Integer, xbean.FillGridInfo> _e_ : this.costs.entrySet())
/*      */     {
/*  134 */       _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getKey()).intValue());
/*  135 */       _size_ += CodedOutputStream.computeMessageSize(4, (ppbio.Message)_e_.getValue());
/*      */     }
/*  137 */     _size_ += CodedOutputStream.computeInt64Size(5, this.end_time);
/*  138 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  144 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  147 */       _output_.writeInt32(1, this.status);
/*  148 */       _output_.writeInt32(2, this.cur_index);
/*  149 */       _output_.writeInt64(3, this.start_time);
/*  150 */       for (Map.Entry<Integer, xbean.FillGridInfo> _e_ : this.costs.entrySet())
/*      */       {
/*  152 */         _output_.writeInt32(4, ((Integer)_e_.getKey()).intValue());
/*  153 */         _output_.writeMessage(4, (ppbio.Message)_e_.getValue());
/*      */       }
/*  155 */       _output_.writeInt64(5, this.end_time);
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
/*  183 */           this.status = _input_.readInt32();
/*  184 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  188 */           this.cur_index = _input_.readInt32();
/*  189 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  193 */           this.start_time = _input_.readInt64();
/*  194 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  198 */           int _k_ = 0;
/*  199 */           _k_ = _input_.readInt32();
/*  200 */           int readTag = _input_.readTag();
/*  201 */           if (34 != readTag)
/*      */           {
/*  203 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  205 */           xbean.FillGridInfo _v_ = new FillGridInfo(0, this, "costs");
/*  206 */           _input_.readMessage(_v_);
/*  207 */           this.costs.put(Integer.valueOf(_k_), _v_);
/*  208 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  212 */           this.end_time = _input_.readInt64();
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
/*      */   public xbean.MassExpInfo copy()
/*      */   {
/*  240 */     _xdb_verify_unsafe_();
/*  241 */     return new MassExpInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MassExpInfo toData()
/*      */   {
/*  247 */     _xdb_verify_unsafe_();
/*  248 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.MassExpInfo toBean()
/*      */   {
/*  253 */     _xdb_verify_unsafe_();
/*  254 */     return new MassExpInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MassExpInfo toDataIf()
/*      */   {
/*  260 */     _xdb_verify_unsafe_();
/*  261 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.MassExpInfo toBeanIf()
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
/*      */   public int getStatus()
/*      */   {
/*  281 */     _xdb_verify_unsafe_();
/*  282 */     return this.status;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCur_index()
/*      */   {
/*  289 */     _xdb_verify_unsafe_();
/*  290 */     return this.cur_index;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getStart_time()
/*      */   {
/*  297 */     _xdb_verify_unsafe_();
/*  298 */     return this.start_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.FillGridInfo> getCosts()
/*      */   {
/*  305 */     _xdb_verify_unsafe_();
/*  306 */     return xdb.Logs.logMap(new LogKey(this, "costs"), this.costs);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.FillGridInfo> getCostsAsData()
/*      */   {
/*  313 */     _xdb_verify_unsafe_();
/*      */     
/*  315 */     MassExpInfo _o_ = this;
/*  316 */     Map<Integer, xbean.FillGridInfo> costs = new HashMap();
/*  317 */     for (Map.Entry<Integer, xbean.FillGridInfo> _e_ : _o_.costs.entrySet())
/*  318 */       costs.put(_e_.getKey(), new FillGridInfo.Data((xbean.FillGridInfo)_e_.getValue()));
/*  319 */     return costs;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getEnd_time()
/*      */   {
/*  326 */     _xdb_verify_unsafe_();
/*  327 */     return this.end_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setStatus(int _v_)
/*      */   {
/*  334 */     _xdb_verify_unsafe_();
/*  335 */     xdb.Logs.logIf(new LogKey(this, "status")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  339 */         new xdb.logs.LogInt(this, MassExpInfo.this.status)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  343 */             MassExpInfo.this.status = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  347 */     });
/*  348 */     this.status = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCur_index(int _v_)
/*      */   {
/*  355 */     _xdb_verify_unsafe_();
/*  356 */     xdb.Logs.logIf(new LogKey(this, "cur_index")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  360 */         new xdb.logs.LogInt(this, MassExpInfo.this.cur_index)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  364 */             MassExpInfo.this.cur_index = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  368 */     });
/*  369 */     this.cur_index = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setStart_time(long _v_)
/*      */   {
/*  376 */     _xdb_verify_unsafe_();
/*  377 */     xdb.Logs.logIf(new LogKey(this, "start_time")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  381 */         new xdb.logs.LogLong(this, MassExpInfo.this.start_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  385 */             MassExpInfo.this.start_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  389 */     });
/*  390 */     this.start_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setEnd_time(long _v_)
/*      */   {
/*  397 */     _xdb_verify_unsafe_();
/*  398 */     xdb.Logs.logIf(new LogKey(this, "end_time")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  402 */         new xdb.logs.LogLong(this, MassExpInfo.this.end_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  406 */             MassExpInfo.this.end_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  410 */     });
/*  411 */     this.end_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  417 */     _xdb_verify_unsafe_();
/*  418 */     MassExpInfo _o_ = null;
/*  419 */     if ((_o1_ instanceof MassExpInfo)) { _o_ = (MassExpInfo)_o1_;
/*  420 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  421 */       return false;
/*  422 */     if (this.status != _o_.status) return false;
/*  423 */     if (this.cur_index != _o_.cur_index) return false;
/*  424 */     if (this.start_time != _o_.start_time) return false;
/*  425 */     if (!this.costs.equals(_o_.costs)) return false;
/*  426 */     if (this.end_time != _o_.end_time) return false;
/*  427 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  433 */     _xdb_verify_unsafe_();
/*  434 */     int _h_ = 0;
/*  435 */     _h_ += this.status;
/*  436 */     _h_ += this.cur_index;
/*  437 */     _h_ = (int)(_h_ + this.start_time);
/*  438 */     _h_ += this.costs.hashCode();
/*  439 */     _h_ = (int)(_h_ + this.end_time);
/*  440 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  446 */     _xdb_verify_unsafe_();
/*  447 */     StringBuilder _sb_ = new StringBuilder();
/*  448 */     _sb_.append("(");
/*  449 */     _sb_.append(this.status);
/*  450 */     _sb_.append(",");
/*  451 */     _sb_.append(this.cur_index);
/*  452 */     _sb_.append(",");
/*  453 */     _sb_.append(this.start_time);
/*  454 */     _sb_.append(",");
/*  455 */     _sb_.append(this.costs);
/*  456 */     _sb_.append(",");
/*  457 */     _sb_.append(this.end_time);
/*  458 */     _sb_.append(")");
/*  459 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  465 */     ListenableBean lb = new ListenableBean();
/*  466 */     lb.add(new ListenableChanged().setVarName("status"));
/*  467 */     lb.add(new ListenableChanged().setVarName("cur_index"));
/*  468 */     lb.add(new ListenableChanged().setVarName("start_time"));
/*  469 */     lb.add(new xdb.logs.ListenableMap().setVarName("costs"));
/*  470 */     lb.add(new ListenableChanged().setVarName("end_time"));
/*  471 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.MassExpInfo {
/*      */     private Const() {}
/*      */     
/*      */     MassExpInfo nThis() {
/*  478 */       return MassExpInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  484 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MassExpInfo copy()
/*      */     {
/*  490 */       return MassExpInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MassExpInfo toData()
/*      */     {
/*  496 */       return MassExpInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.MassExpInfo toBean()
/*      */     {
/*  501 */       return MassExpInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MassExpInfo toDataIf()
/*      */     {
/*  507 */       return MassExpInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.MassExpInfo toBeanIf()
/*      */     {
/*  512 */       return MassExpInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getStatus()
/*      */     {
/*  519 */       MassExpInfo.this._xdb_verify_unsafe_();
/*  520 */       return MassExpInfo.this.status;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCur_index()
/*      */     {
/*  527 */       MassExpInfo.this._xdb_verify_unsafe_();
/*  528 */       return MassExpInfo.this.cur_index;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getStart_time()
/*      */     {
/*  535 */       MassExpInfo.this._xdb_verify_unsafe_();
/*  536 */       return MassExpInfo.this.start_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.FillGridInfo> getCosts()
/*      */     {
/*  543 */       MassExpInfo.this._xdb_verify_unsafe_();
/*  544 */       return xdb.Consts.constMap(MassExpInfo.this.costs);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.FillGridInfo> getCostsAsData()
/*      */     {
/*  551 */       MassExpInfo.this._xdb_verify_unsafe_();
/*      */       
/*  553 */       MassExpInfo _o_ = MassExpInfo.this;
/*  554 */       Map<Integer, xbean.FillGridInfo> costs = new HashMap();
/*  555 */       for (Map.Entry<Integer, xbean.FillGridInfo> _e_ : _o_.costs.entrySet())
/*  556 */         costs.put(_e_.getKey(), new FillGridInfo.Data((xbean.FillGridInfo)_e_.getValue()));
/*  557 */       return costs;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getEnd_time()
/*      */     {
/*  564 */       MassExpInfo.this._xdb_verify_unsafe_();
/*  565 */       return MassExpInfo.this.end_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStatus(int _v_)
/*      */     {
/*  572 */       MassExpInfo.this._xdb_verify_unsafe_();
/*  573 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCur_index(int _v_)
/*      */     {
/*  580 */       MassExpInfo.this._xdb_verify_unsafe_();
/*  581 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStart_time(long _v_)
/*      */     {
/*  588 */       MassExpInfo.this._xdb_verify_unsafe_();
/*  589 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEnd_time(long _v_)
/*      */     {
/*  596 */       MassExpInfo.this._xdb_verify_unsafe_();
/*  597 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  603 */       MassExpInfo.this._xdb_verify_unsafe_();
/*  604 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  610 */       MassExpInfo.this._xdb_verify_unsafe_();
/*  611 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  617 */       return MassExpInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  623 */       return MassExpInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  629 */       MassExpInfo.this._xdb_verify_unsafe_();
/*  630 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  636 */       return MassExpInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  642 */       return MassExpInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  648 */       MassExpInfo.this._xdb_verify_unsafe_();
/*  649 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  655 */       return MassExpInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  661 */       return MassExpInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  667 */       return MassExpInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  673 */       return MassExpInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  679 */       return MassExpInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  685 */       return MassExpInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  691 */       return MassExpInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.MassExpInfo
/*      */   {
/*      */     private int status;
/*      */     
/*      */     private int cur_index;
/*      */     
/*      */     private long start_time;
/*      */     
/*      */     private HashMap<Integer, xbean.FillGridInfo> costs;
/*      */     
/*      */     private long end_time;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  711 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  716 */       this.costs = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.MassExpInfo _o1_)
/*      */     {
/*  721 */       if ((_o1_ instanceof MassExpInfo)) { assign((MassExpInfo)_o1_);
/*  722 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  723 */       } else if ((_o1_ instanceof MassExpInfo.Const)) assign(((MassExpInfo.Const)_o1_).nThis()); else {
/*  724 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(MassExpInfo _o_) {
/*  729 */       this.status = _o_.status;
/*  730 */       this.cur_index = _o_.cur_index;
/*  731 */       this.start_time = _o_.start_time;
/*  732 */       this.costs = new HashMap();
/*  733 */       for (Map.Entry<Integer, xbean.FillGridInfo> _e_ : _o_.costs.entrySet())
/*  734 */         this.costs.put(_e_.getKey(), new FillGridInfo.Data((xbean.FillGridInfo)_e_.getValue()));
/*  735 */       this.end_time = _o_.end_time;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  740 */       this.status = _o_.status;
/*  741 */       this.cur_index = _o_.cur_index;
/*  742 */       this.start_time = _o_.start_time;
/*  743 */       this.costs = new HashMap();
/*  744 */       for (Map.Entry<Integer, xbean.FillGridInfo> _e_ : _o_.costs.entrySet())
/*  745 */         this.costs.put(_e_.getKey(), new FillGridInfo.Data((xbean.FillGridInfo)_e_.getValue()));
/*  746 */       this.end_time = _o_.end_time;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  752 */       _os_.marshal(this.status);
/*  753 */       _os_.marshal(this.cur_index);
/*  754 */       _os_.marshal(this.start_time);
/*  755 */       _os_.compact_uint32(this.costs.size());
/*  756 */       for (Map.Entry<Integer, xbean.FillGridInfo> _e_ : this.costs.entrySet())
/*      */       {
/*  758 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  759 */         ((xbean.FillGridInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/*  761 */       _os_.marshal(this.end_time);
/*  762 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  768 */       this.status = _os_.unmarshal_int();
/*  769 */       this.cur_index = _os_.unmarshal_int();
/*  770 */       this.start_time = _os_.unmarshal_long();
/*      */       
/*  772 */       int size = _os_.uncompact_uint32();
/*  773 */       if (size >= 12)
/*      */       {
/*  775 */         this.costs = new HashMap(size * 2);
/*      */       }
/*  777 */       for (; size > 0; size--)
/*      */       {
/*  779 */         int _k_ = 0;
/*  780 */         _k_ = _os_.unmarshal_int();
/*  781 */         xbean.FillGridInfo _v_ = xbean.Pod.newFillGridInfoData();
/*  782 */         _v_.unmarshal(_os_);
/*  783 */         this.costs.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*  786 */       this.end_time = _os_.unmarshal_long();
/*  787 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  793 */       int _size_ = 0;
/*  794 */       _size_ += CodedOutputStream.computeInt32Size(1, this.status);
/*  795 */       _size_ += CodedOutputStream.computeInt32Size(2, this.cur_index);
/*  796 */       _size_ += CodedOutputStream.computeInt64Size(3, this.start_time);
/*  797 */       for (Map.Entry<Integer, xbean.FillGridInfo> _e_ : this.costs.entrySet())
/*      */       {
/*  799 */         _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getKey()).intValue());
/*  800 */         _size_ += CodedOutputStream.computeMessageSize(4, (ppbio.Message)_e_.getValue());
/*      */       }
/*  802 */       _size_ += CodedOutputStream.computeInt64Size(5, this.end_time);
/*  803 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  811 */         _output_.writeInt32(1, this.status);
/*  812 */         _output_.writeInt32(2, this.cur_index);
/*  813 */         _output_.writeInt64(3, this.start_time);
/*  814 */         for (Map.Entry<Integer, xbean.FillGridInfo> _e_ : this.costs.entrySet())
/*      */         {
/*  816 */           _output_.writeInt32(4, ((Integer)_e_.getKey()).intValue());
/*  817 */           _output_.writeMessage(4, (ppbio.Message)_e_.getValue());
/*      */         }
/*  819 */         _output_.writeInt64(5, this.end_time);
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
/*  846 */             this.status = _input_.readInt32();
/*  847 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  851 */             this.cur_index = _input_.readInt32();
/*  852 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  856 */             this.start_time = _input_.readInt64();
/*  857 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  861 */             int _k_ = 0;
/*  862 */             _k_ = _input_.readInt32();
/*  863 */             int readTag = _input_.readTag();
/*  864 */             if (34 != readTag)
/*      */             {
/*  866 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  868 */             xbean.FillGridInfo _v_ = xbean.Pod.newFillGridInfoData();
/*  869 */             _input_.readMessage(_v_);
/*  870 */             this.costs.put(Integer.valueOf(_k_), _v_);
/*  871 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  875 */             this.end_time = _input_.readInt64();
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
/*      */     public xbean.MassExpInfo copy()
/*      */     {
/*  903 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MassExpInfo toData()
/*      */     {
/*  909 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.MassExpInfo toBean()
/*      */     {
/*  914 */       return new MassExpInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MassExpInfo toDataIf()
/*      */     {
/*  920 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.MassExpInfo toBeanIf()
/*      */     {
/*  925 */       return new MassExpInfo(this, null, null);
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
/*      */     public int getStatus()
/*      */     {
/*  962 */       return this.status;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCur_index()
/*      */     {
/*  969 */       return this.cur_index;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getStart_time()
/*      */     {
/*  976 */       return this.start_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.FillGridInfo> getCosts()
/*      */     {
/*  983 */       return this.costs;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.FillGridInfo> getCostsAsData()
/*      */     {
/*  990 */       return this.costs;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getEnd_time()
/*      */     {
/*  997 */       return this.end_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStatus(int _v_)
/*      */     {
/* 1004 */       this.status = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCur_index(int _v_)
/*      */     {
/* 1011 */       this.cur_index = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStart_time(long _v_)
/*      */     {
/* 1018 */       this.start_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEnd_time(long _v_)
/*      */     {
/* 1025 */       this.end_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1031 */       if (!(_o1_ instanceof Data)) return false;
/* 1032 */       Data _o_ = (Data)_o1_;
/* 1033 */       if (this.status != _o_.status) return false;
/* 1034 */       if (this.cur_index != _o_.cur_index) return false;
/* 1035 */       if (this.start_time != _o_.start_time) return false;
/* 1036 */       if (!this.costs.equals(_o_.costs)) return false;
/* 1037 */       if (this.end_time != _o_.end_time) return false;
/* 1038 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1044 */       int _h_ = 0;
/* 1045 */       _h_ += this.status;
/* 1046 */       _h_ += this.cur_index;
/* 1047 */       _h_ = (int)(_h_ + this.start_time);
/* 1048 */       _h_ += this.costs.hashCode();
/* 1049 */       _h_ = (int)(_h_ + this.end_time);
/* 1050 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1056 */       StringBuilder _sb_ = new StringBuilder();
/* 1057 */       _sb_.append("(");
/* 1058 */       _sb_.append(this.status);
/* 1059 */       _sb_.append(",");
/* 1060 */       _sb_.append(this.cur_index);
/* 1061 */       _sb_.append(",");
/* 1062 */       _sb_.append(this.start_time);
/* 1063 */       _sb_.append(",");
/* 1064 */       _sb_.append(this.costs);
/* 1065 */       _sb_.append(",");
/* 1066 */       _sb_.append(this.end_time);
/* 1067 */       _sb_.append(")");
/* 1068 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MassExpInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */