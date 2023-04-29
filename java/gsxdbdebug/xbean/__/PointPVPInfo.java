/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.HashSet;
/*      */ import java.util.Set;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.util.SetX;
/*      */ 
/*      */ public final class PointPVPInfo extends XBean implements xbean.PointPVPInfo
/*      */ {
/*      */   private int activity_cfgid;
/*      */   private int zone;
/*      */   private int time_point_cfgid;
/*      */   private long start_time;
/*      */   private SetX<Long> fights;
/*      */   private boolean finish;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.activity_cfgid = 0;
/*   29 */     this.zone = 0;
/*   30 */     this.time_point_cfgid = 0;
/*   31 */     this.start_time = 0L;
/*   32 */     this.fights.clear();
/*   33 */     this.finish = false;
/*      */   }
/*      */   
/*      */   PointPVPInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*   39 */     this.fights = new SetX();
/*   40 */     this.finish = false;
/*      */   }
/*      */   
/*      */   public PointPVPInfo()
/*      */   {
/*   45 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public PointPVPInfo(PointPVPInfo _o_)
/*      */   {
/*   50 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   PointPVPInfo(xbean.PointPVPInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   55 */     super(_xp_, _vn_);
/*   56 */     if ((_o1_ instanceof PointPVPInfo)) { assign((PointPVPInfo)_o1_);
/*   57 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   58 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   59 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(PointPVPInfo _o_) {
/*   64 */     _o_._xdb_verify_unsafe_();
/*   65 */     this.activity_cfgid = _o_.activity_cfgid;
/*   66 */     this.zone = _o_.zone;
/*   67 */     this.time_point_cfgid = _o_.time_point_cfgid;
/*   68 */     this.start_time = _o_.start_time;
/*   69 */     this.fights = new SetX();
/*   70 */     this.fights.addAll(_o_.fights);
/*   71 */     this.finish = _o_.finish;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   76 */     this.activity_cfgid = _o_.activity_cfgid;
/*   77 */     this.zone = _o_.zone;
/*   78 */     this.time_point_cfgid = _o_.time_point_cfgid;
/*   79 */     this.start_time = _o_.start_time;
/*   80 */     this.fights = new SetX();
/*   81 */     this.fights.addAll(_o_.fights);
/*   82 */     this.finish = _o_.finish;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   88 */     _xdb_verify_unsafe_();
/*   89 */     _os_.marshal(this.activity_cfgid);
/*   90 */     _os_.marshal(this.zone);
/*   91 */     _os_.marshal(this.time_point_cfgid);
/*   92 */     _os_.marshal(this.start_time);
/*   93 */     _os_.compact_uint32(this.fights.size());
/*   94 */     for (Long _v_ : this.fights)
/*      */     {
/*   96 */       _os_.marshal(_v_.longValue());
/*      */     }
/*   98 */     _os_.marshal(this.finish);
/*   99 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  105 */     _xdb_verify_unsafe_();
/*  106 */     this.activity_cfgid = _os_.unmarshal_int();
/*  107 */     this.zone = _os_.unmarshal_int();
/*  108 */     this.time_point_cfgid = _os_.unmarshal_int();
/*  109 */     this.start_time = _os_.unmarshal_long();
/*  110 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  112 */       long _v_ = 0L;
/*  113 */       _v_ = _os_.unmarshal_long();
/*  114 */       this.fights.add(Long.valueOf(_v_));
/*      */     }
/*  116 */     this.finish = _os_.unmarshal_boolean();
/*  117 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  123 */     _xdb_verify_unsafe_();
/*  124 */     int _size_ = 0;
/*  125 */     _size_ += CodedOutputStream.computeInt32Size(1, this.activity_cfgid);
/*  126 */     _size_ += CodedOutputStream.computeInt32Size(2, this.zone);
/*  127 */     _size_ += CodedOutputStream.computeInt32Size(3, this.time_point_cfgid);
/*  128 */     _size_ += CodedOutputStream.computeInt64Size(4, this.start_time);
/*  129 */     for (Long _v_ : this.fights)
/*      */     {
/*  131 */       _size_ += CodedOutputStream.computeInt64Size(5, _v_.longValue());
/*      */     }
/*  133 */     _size_ += CodedOutputStream.computeBoolSize(6, this.finish);
/*  134 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  140 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  143 */       _output_.writeInt32(1, this.activity_cfgid);
/*  144 */       _output_.writeInt32(2, this.zone);
/*  145 */       _output_.writeInt32(3, this.time_point_cfgid);
/*  146 */       _output_.writeInt64(4, this.start_time);
/*  147 */       for (Long _v_ : this.fights)
/*      */       {
/*  149 */         _output_.writeInt64(5, _v_.longValue());
/*      */       }
/*  151 */       _output_.writeBool(6, this.finish);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  155 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  157 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  163 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  166 */       boolean done = false;
/*  167 */       while (!done)
/*      */       {
/*  169 */         int tag = _input_.readTag();
/*  170 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  174 */           done = true;
/*  175 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  179 */           this.activity_cfgid = _input_.readInt32();
/*  180 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  184 */           this.zone = _input_.readInt32();
/*  185 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  189 */           this.time_point_cfgid = _input_.readInt32();
/*  190 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  194 */           this.start_time = _input_.readInt64();
/*  195 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  199 */           long _v_ = 0L;
/*  200 */           _v_ = _input_.readInt64();
/*  201 */           this.fights.add(Long.valueOf(_v_));
/*  202 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  206 */           this.finish = _input_.readBool();
/*  207 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  211 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  213 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  222 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  226 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  228 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.PointPVPInfo copy()
/*      */   {
/*  234 */     _xdb_verify_unsafe_();
/*  235 */     return new PointPVPInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.PointPVPInfo toData()
/*      */   {
/*  241 */     _xdb_verify_unsafe_();
/*  242 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.PointPVPInfo toBean()
/*      */   {
/*  247 */     _xdb_verify_unsafe_();
/*  248 */     return new PointPVPInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.PointPVPInfo toDataIf()
/*      */   {
/*  254 */     _xdb_verify_unsafe_();
/*  255 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.PointPVPInfo toBeanIf()
/*      */   {
/*  260 */     _xdb_verify_unsafe_();
/*  261 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  267 */     _xdb_verify_unsafe_();
/*  268 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getActivity_cfgid()
/*      */   {
/*  275 */     _xdb_verify_unsafe_();
/*  276 */     return this.activity_cfgid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getZone()
/*      */   {
/*  283 */     _xdb_verify_unsafe_();
/*  284 */     return this.zone;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getTime_point_cfgid()
/*      */   {
/*  291 */     _xdb_verify_unsafe_();
/*  292 */     return this.time_point_cfgid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getStart_time()
/*      */   {
/*  299 */     _xdb_verify_unsafe_();
/*  300 */     return this.start_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Long> getFights()
/*      */   {
/*  307 */     _xdb_verify_unsafe_();
/*  308 */     return xdb.Logs.logSet(new LogKey(this, "fights"), this.fights);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Long> getFightsAsData()
/*      */   {
/*  314 */     _xdb_verify_unsafe_();
/*      */     
/*  316 */     PointPVPInfo _o_ = this;
/*  317 */     Set<Long> fights = new SetX();
/*  318 */     fights.addAll(_o_.fights);
/*  319 */     return fights;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getFinish()
/*      */   {
/*  326 */     _xdb_verify_unsafe_();
/*  327 */     return this.finish;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setActivity_cfgid(int _v_)
/*      */   {
/*  334 */     _xdb_verify_unsafe_();
/*  335 */     xdb.Logs.logIf(new LogKey(this, "activity_cfgid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  339 */         new LogInt(this, PointPVPInfo.this.activity_cfgid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  343 */             PointPVPInfo.this.activity_cfgid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  347 */     });
/*  348 */     this.activity_cfgid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setZone(int _v_)
/*      */   {
/*  355 */     _xdb_verify_unsafe_();
/*  356 */     xdb.Logs.logIf(new LogKey(this, "zone")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  360 */         new LogInt(this, PointPVPInfo.this.zone)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  364 */             PointPVPInfo.this.zone = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  368 */     });
/*  369 */     this.zone = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTime_point_cfgid(int _v_)
/*      */   {
/*  376 */     _xdb_verify_unsafe_();
/*  377 */     xdb.Logs.logIf(new LogKey(this, "time_point_cfgid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  381 */         new LogInt(this, PointPVPInfo.this.time_point_cfgid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  385 */             PointPVPInfo.this.time_point_cfgid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  389 */     });
/*  390 */     this.time_point_cfgid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setStart_time(long _v_)
/*      */   {
/*  397 */     _xdb_verify_unsafe_();
/*  398 */     xdb.Logs.logIf(new LogKey(this, "start_time")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  402 */         new xdb.logs.LogLong(this, PointPVPInfo.this.start_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  406 */             PointPVPInfo.this.start_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  410 */     });
/*  411 */     this.start_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFinish(boolean _v_)
/*      */   {
/*  418 */     _xdb_verify_unsafe_();
/*  419 */     xdb.Logs.logIf(new LogKey(this, "finish")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  423 */         new xdb.logs.LogObject(this, Boolean.valueOf(PointPVPInfo.this.finish))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  427 */             PointPVPInfo.this.finish = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  431 */     });
/*  432 */     this.finish = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  438 */     _xdb_verify_unsafe_();
/*  439 */     PointPVPInfo _o_ = null;
/*  440 */     if ((_o1_ instanceof PointPVPInfo)) { _o_ = (PointPVPInfo)_o1_;
/*  441 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  442 */       return false;
/*  443 */     if (this.activity_cfgid != _o_.activity_cfgid) return false;
/*  444 */     if (this.zone != _o_.zone) return false;
/*  445 */     if (this.time_point_cfgid != _o_.time_point_cfgid) return false;
/*  446 */     if (this.start_time != _o_.start_time) return false;
/*  447 */     if (!this.fights.equals(_o_.fights)) return false;
/*  448 */     if (this.finish != _o_.finish) return false;
/*  449 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  455 */     _xdb_verify_unsafe_();
/*  456 */     int _h_ = 0;
/*  457 */     _h_ += this.activity_cfgid;
/*  458 */     _h_ += this.zone;
/*  459 */     _h_ += this.time_point_cfgid;
/*  460 */     _h_ = (int)(_h_ + this.start_time);
/*  461 */     _h_ += this.fights.hashCode();
/*  462 */     _h_ += (this.finish ? 1231 : 1237);
/*  463 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  469 */     _xdb_verify_unsafe_();
/*  470 */     StringBuilder _sb_ = new StringBuilder();
/*  471 */     _sb_.append("(");
/*  472 */     _sb_.append(this.activity_cfgid);
/*  473 */     _sb_.append(",");
/*  474 */     _sb_.append(this.zone);
/*  475 */     _sb_.append(",");
/*  476 */     _sb_.append(this.time_point_cfgid);
/*  477 */     _sb_.append(",");
/*  478 */     _sb_.append(this.start_time);
/*  479 */     _sb_.append(",");
/*  480 */     _sb_.append(this.fights);
/*  481 */     _sb_.append(",");
/*  482 */     _sb_.append(this.finish);
/*  483 */     _sb_.append(")");
/*  484 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  490 */     ListenableBean lb = new ListenableBean();
/*  491 */     lb.add(new ListenableChanged().setVarName("activity_cfgid"));
/*  492 */     lb.add(new ListenableChanged().setVarName("zone"));
/*  493 */     lb.add(new ListenableChanged().setVarName("time_point_cfgid"));
/*  494 */     lb.add(new ListenableChanged().setVarName("start_time"));
/*  495 */     lb.add(new xdb.logs.ListenableSet().setVarName("fights"));
/*  496 */     lb.add(new ListenableChanged().setVarName("finish"));
/*  497 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.PointPVPInfo {
/*      */     private Const() {}
/*      */     
/*      */     PointPVPInfo nThis() {
/*  504 */       return PointPVPInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  510 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PointPVPInfo copy()
/*      */     {
/*  516 */       return PointPVPInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PointPVPInfo toData()
/*      */     {
/*  522 */       return PointPVPInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.PointPVPInfo toBean()
/*      */     {
/*  527 */       return PointPVPInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PointPVPInfo toDataIf()
/*      */     {
/*  533 */       return PointPVPInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.PointPVPInfo toBeanIf()
/*      */     {
/*  538 */       return PointPVPInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getActivity_cfgid()
/*      */     {
/*  545 */       PointPVPInfo.this._xdb_verify_unsafe_();
/*  546 */       return PointPVPInfo.this.activity_cfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getZone()
/*      */     {
/*  553 */       PointPVPInfo.this._xdb_verify_unsafe_();
/*  554 */       return PointPVPInfo.this.zone;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTime_point_cfgid()
/*      */     {
/*  561 */       PointPVPInfo.this._xdb_verify_unsafe_();
/*  562 */       return PointPVPInfo.this.time_point_cfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getStart_time()
/*      */     {
/*  569 */       PointPVPInfo.this._xdb_verify_unsafe_();
/*  570 */       return PointPVPInfo.this.start_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getFights()
/*      */     {
/*  577 */       PointPVPInfo.this._xdb_verify_unsafe_();
/*  578 */       return xdb.Consts.constSet(PointPVPInfo.this.fights);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Long> getFightsAsData()
/*      */     {
/*  584 */       PointPVPInfo.this._xdb_verify_unsafe_();
/*      */       
/*  586 */       PointPVPInfo _o_ = PointPVPInfo.this;
/*  587 */       Set<Long> fights = new SetX();
/*  588 */       fights.addAll(_o_.fights);
/*  589 */       return fights;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getFinish()
/*      */     {
/*  596 */       PointPVPInfo.this._xdb_verify_unsafe_();
/*  597 */       return PointPVPInfo.this.finish;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActivity_cfgid(int _v_)
/*      */     {
/*  604 */       PointPVPInfo.this._xdb_verify_unsafe_();
/*  605 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setZone(int _v_)
/*      */     {
/*  612 */       PointPVPInfo.this._xdb_verify_unsafe_();
/*  613 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTime_point_cfgid(int _v_)
/*      */     {
/*  620 */       PointPVPInfo.this._xdb_verify_unsafe_();
/*  621 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStart_time(long _v_)
/*      */     {
/*  628 */       PointPVPInfo.this._xdb_verify_unsafe_();
/*  629 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFinish(boolean _v_)
/*      */     {
/*  636 */       PointPVPInfo.this._xdb_verify_unsafe_();
/*  637 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  643 */       PointPVPInfo.this._xdb_verify_unsafe_();
/*  644 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  650 */       PointPVPInfo.this._xdb_verify_unsafe_();
/*  651 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  657 */       return PointPVPInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  663 */       return PointPVPInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  669 */       PointPVPInfo.this._xdb_verify_unsafe_();
/*  670 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  676 */       return PointPVPInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  682 */       return PointPVPInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  688 */       PointPVPInfo.this._xdb_verify_unsafe_();
/*  689 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  695 */       return PointPVPInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  701 */       return PointPVPInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  707 */       return PointPVPInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  713 */       return PointPVPInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  719 */       return PointPVPInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  725 */       return PointPVPInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  731 */       return PointPVPInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.PointPVPInfo
/*      */   {
/*      */     private int activity_cfgid;
/*      */     
/*      */     private int zone;
/*      */     
/*      */     private int time_point_cfgid;
/*      */     
/*      */     private long start_time;
/*      */     
/*      */     private HashSet<Long> fights;
/*      */     
/*      */     private boolean finish;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  753 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  758 */       this.fights = new HashSet();
/*  759 */       this.finish = false;
/*      */     }
/*      */     
/*      */     Data(xbean.PointPVPInfo _o1_)
/*      */     {
/*  764 */       if ((_o1_ instanceof PointPVPInfo)) { assign((PointPVPInfo)_o1_);
/*  765 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  766 */       } else if ((_o1_ instanceof PointPVPInfo.Const)) assign(((PointPVPInfo.Const)_o1_).nThis()); else {
/*  767 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(PointPVPInfo _o_) {
/*  772 */       this.activity_cfgid = _o_.activity_cfgid;
/*  773 */       this.zone = _o_.zone;
/*  774 */       this.time_point_cfgid = _o_.time_point_cfgid;
/*  775 */       this.start_time = _o_.start_time;
/*  776 */       this.fights = new HashSet();
/*  777 */       this.fights.addAll(_o_.fights);
/*  778 */       this.finish = _o_.finish;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  783 */       this.activity_cfgid = _o_.activity_cfgid;
/*  784 */       this.zone = _o_.zone;
/*  785 */       this.time_point_cfgid = _o_.time_point_cfgid;
/*  786 */       this.start_time = _o_.start_time;
/*  787 */       this.fights = new HashSet();
/*  788 */       this.fights.addAll(_o_.fights);
/*  789 */       this.finish = _o_.finish;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  795 */       _os_.marshal(this.activity_cfgid);
/*  796 */       _os_.marshal(this.zone);
/*  797 */       _os_.marshal(this.time_point_cfgid);
/*  798 */       _os_.marshal(this.start_time);
/*  799 */       _os_.compact_uint32(this.fights.size());
/*  800 */       for (Long _v_ : this.fights)
/*      */       {
/*  802 */         _os_.marshal(_v_.longValue());
/*      */       }
/*  804 */       _os_.marshal(this.finish);
/*  805 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  811 */       this.activity_cfgid = _os_.unmarshal_int();
/*  812 */       this.zone = _os_.unmarshal_int();
/*  813 */       this.time_point_cfgid = _os_.unmarshal_int();
/*  814 */       this.start_time = _os_.unmarshal_long();
/*  815 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  817 */         long _v_ = 0L;
/*  818 */         _v_ = _os_.unmarshal_long();
/*  819 */         this.fights.add(Long.valueOf(_v_));
/*      */       }
/*  821 */       this.finish = _os_.unmarshal_boolean();
/*  822 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  828 */       int _size_ = 0;
/*  829 */       _size_ += CodedOutputStream.computeInt32Size(1, this.activity_cfgid);
/*  830 */       _size_ += CodedOutputStream.computeInt32Size(2, this.zone);
/*  831 */       _size_ += CodedOutputStream.computeInt32Size(3, this.time_point_cfgid);
/*  832 */       _size_ += CodedOutputStream.computeInt64Size(4, this.start_time);
/*  833 */       for (Long _v_ : this.fights)
/*      */       {
/*  835 */         _size_ += CodedOutputStream.computeInt64Size(5, _v_.longValue());
/*      */       }
/*  837 */       _size_ += CodedOutputStream.computeBoolSize(6, this.finish);
/*  838 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  846 */         _output_.writeInt32(1, this.activity_cfgid);
/*  847 */         _output_.writeInt32(2, this.zone);
/*  848 */         _output_.writeInt32(3, this.time_point_cfgid);
/*  849 */         _output_.writeInt64(4, this.start_time);
/*  850 */         for (Long _v_ : this.fights)
/*      */         {
/*  852 */           _output_.writeInt64(5, _v_.longValue());
/*      */         }
/*  854 */         _output_.writeBool(6, this.finish);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  858 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  860 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  868 */         boolean done = false;
/*  869 */         while (!done)
/*      */         {
/*  871 */           int tag = _input_.readTag();
/*  872 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  876 */             done = true;
/*  877 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  881 */             this.activity_cfgid = _input_.readInt32();
/*  882 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  886 */             this.zone = _input_.readInt32();
/*  887 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  891 */             this.time_point_cfgid = _input_.readInt32();
/*  892 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  896 */             this.start_time = _input_.readInt64();
/*  897 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  901 */             long _v_ = 0L;
/*  902 */             _v_ = _input_.readInt64();
/*  903 */             this.fights.add(Long.valueOf(_v_));
/*  904 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  908 */             this.finish = _input_.readBool();
/*  909 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  913 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  915 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  924 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  928 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  930 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PointPVPInfo copy()
/*      */     {
/*  936 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PointPVPInfo toData()
/*      */     {
/*  942 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.PointPVPInfo toBean()
/*      */     {
/*  947 */       return new PointPVPInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PointPVPInfo toDataIf()
/*      */     {
/*  953 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.PointPVPInfo toBeanIf()
/*      */     {
/*  958 */       return new PointPVPInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  964 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  968 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  972 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  976 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  980 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  984 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  988 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getActivity_cfgid()
/*      */     {
/*  995 */       return this.activity_cfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getZone()
/*      */     {
/* 1002 */       return this.zone;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTime_point_cfgid()
/*      */     {
/* 1009 */       return this.time_point_cfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getStart_time()
/*      */     {
/* 1016 */       return this.start_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getFights()
/*      */     {
/* 1023 */       return this.fights;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getFightsAsData()
/*      */     {
/* 1030 */       return this.fights;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getFinish()
/*      */     {
/* 1037 */       return this.finish;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActivity_cfgid(int _v_)
/*      */     {
/* 1044 */       this.activity_cfgid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setZone(int _v_)
/*      */     {
/* 1051 */       this.zone = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTime_point_cfgid(int _v_)
/*      */     {
/* 1058 */       this.time_point_cfgid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStart_time(long _v_)
/*      */     {
/* 1065 */       this.start_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFinish(boolean _v_)
/*      */     {
/* 1072 */       this.finish = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1078 */       if (!(_o1_ instanceof Data)) return false;
/* 1079 */       Data _o_ = (Data)_o1_;
/* 1080 */       if (this.activity_cfgid != _o_.activity_cfgid) return false;
/* 1081 */       if (this.zone != _o_.zone) return false;
/* 1082 */       if (this.time_point_cfgid != _o_.time_point_cfgid) return false;
/* 1083 */       if (this.start_time != _o_.start_time) return false;
/* 1084 */       if (!this.fights.equals(_o_.fights)) return false;
/* 1085 */       if (this.finish != _o_.finish) return false;
/* 1086 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1092 */       int _h_ = 0;
/* 1093 */       _h_ += this.activity_cfgid;
/* 1094 */       _h_ += this.zone;
/* 1095 */       _h_ += this.time_point_cfgid;
/* 1096 */       _h_ = (int)(_h_ + this.start_time);
/* 1097 */       _h_ += this.fights.hashCode();
/* 1098 */       _h_ += (this.finish ? 1231 : 1237);
/* 1099 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1105 */       StringBuilder _sb_ = new StringBuilder();
/* 1106 */       _sb_.append("(");
/* 1107 */       _sb_.append(this.activity_cfgid);
/* 1108 */       _sb_.append(",");
/* 1109 */       _sb_.append(this.zone);
/* 1110 */       _sb_.append(",");
/* 1111 */       _sb_.append(this.time_point_cfgid);
/* 1112 */       _sb_.append(",");
/* 1113 */       _sb_.append(this.start_time);
/* 1114 */       _sb_.append(",");
/* 1115 */       _sb_.append(this.fights);
/* 1116 */       _sb_.append(",");
/* 1117 */       _sb_.append(this.finish);
/* 1118 */       _sb_.append(")");
/* 1119 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\PointPVPInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */