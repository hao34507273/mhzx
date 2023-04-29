/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Bean;
/*      */ import xdb.Consts;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.logs.LogLong;
/*      */ 
/*      */ public final class Role2ChildrenInfo extends XBean implements xbean.Role2ChildrenInfo
/*      */ {
/*      */   private ArrayList<Long> child_id_list;
/*      */   private ArrayList<Long> child_bag_id_list;
/*      */   private long show_child_id;
/*      */   private int signal_way_child_score;
/*      */   private int show_child_period;
/*      */   private xbean.ChildFashionInfo fashion_info;
/*      */   private int total_rating;
/*      */   private int total_discard_child_num;
/*      */   private int period_recall_times;
/*      */   private long recall_period_refresh_time;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   36 */     this.child_id_list.clear();
/*   37 */     this.child_bag_id_list.clear();
/*   38 */     this.show_child_id = -1L;
/*   39 */     this.signal_way_child_score = 0;
/*   40 */     this.show_child_period = 0;
/*   41 */     this.fashion_info._reset_unsafe_();
/*   42 */     this.total_rating = 0;
/*   43 */     this.total_discard_child_num = 0;
/*   44 */     this.period_recall_times = 0;
/*   45 */     this.recall_period_refresh_time = 0L;
/*      */   }
/*      */   
/*      */   Role2ChildrenInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   50 */     super(_xp_, _vn_);
/*   51 */     this.child_id_list = new ArrayList();
/*   52 */     this.child_bag_id_list = new ArrayList();
/*   53 */     this.show_child_id = -1L;
/*   54 */     this.fashion_info = new ChildFashionInfo(0, this, "fashion_info");
/*      */   }
/*      */   
/*      */   public Role2ChildrenInfo()
/*      */   {
/*   59 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public Role2ChildrenInfo(Role2ChildrenInfo _o_)
/*      */   {
/*   64 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   Role2ChildrenInfo(xbean.Role2ChildrenInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   69 */     super(_xp_, _vn_);
/*   70 */     if ((_o1_ instanceof Role2ChildrenInfo)) { assign((Role2ChildrenInfo)_o1_);
/*   71 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   72 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   73 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Role2ChildrenInfo _o_) {
/*   78 */     _o_._xdb_verify_unsafe_();
/*   79 */     this.child_id_list = new ArrayList();
/*   80 */     this.child_id_list.addAll(_o_.child_id_list);
/*   81 */     this.child_bag_id_list = new ArrayList();
/*   82 */     this.child_bag_id_list.addAll(_o_.child_bag_id_list);
/*   83 */     this.show_child_id = _o_.show_child_id;
/*   84 */     this.signal_way_child_score = _o_.signal_way_child_score;
/*   85 */     this.show_child_period = _o_.show_child_period;
/*   86 */     this.fashion_info = new ChildFashionInfo(_o_.fashion_info, this, "fashion_info");
/*   87 */     this.total_rating = _o_.total_rating;
/*   88 */     this.total_discard_child_num = _o_.total_discard_child_num;
/*   89 */     this.period_recall_times = _o_.period_recall_times;
/*   90 */     this.recall_period_refresh_time = _o_.recall_period_refresh_time;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   95 */     this.child_id_list = new ArrayList();
/*   96 */     this.child_id_list.addAll(_o_.child_id_list);
/*   97 */     this.child_bag_id_list = new ArrayList();
/*   98 */     this.child_bag_id_list.addAll(_o_.child_bag_id_list);
/*   99 */     this.show_child_id = _o_.show_child_id;
/*  100 */     this.signal_way_child_score = _o_.signal_way_child_score;
/*  101 */     this.show_child_period = _o_.show_child_period;
/*  102 */     this.fashion_info = new ChildFashionInfo(_o_.fashion_info, this, "fashion_info");
/*  103 */     this.total_rating = _o_.total_rating;
/*  104 */     this.total_discard_child_num = _o_.total_discard_child_num;
/*  105 */     this.period_recall_times = _o_.period_recall_times;
/*  106 */     this.recall_period_refresh_time = _o_.recall_period_refresh_time;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  112 */     _xdb_verify_unsafe_();
/*  113 */     _os_.compact_uint32(this.child_id_list.size());
/*  114 */     for (Long _v_ : this.child_id_list)
/*      */     {
/*  116 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  118 */     _os_.compact_uint32(this.child_bag_id_list.size());
/*  119 */     for (Long _v_ : this.child_bag_id_list)
/*      */     {
/*  121 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  123 */     _os_.marshal(this.show_child_id);
/*  124 */     _os_.marshal(this.signal_way_child_score);
/*  125 */     _os_.marshal(this.show_child_period);
/*  126 */     this.fashion_info.marshal(_os_);
/*  127 */     _os_.marshal(this.total_rating);
/*  128 */     _os_.marshal(this.total_discard_child_num);
/*  129 */     _os_.marshal(this.period_recall_times);
/*  130 */     _os_.marshal(this.recall_period_refresh_time);
/*  131 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  137 */     _xdb_verify_unsafe_();
/*  138 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  140 */       long _v_ = 0L;
/*  141 */       _v_ = _os_.unmarshal_long();
/*  142 */       this.child_id_list.add(Long.valueOf(_v_));
/*      */     }
/*  144 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  146 */       long _v_ = 0L;
/*  147 */       _v_ = _os_.unmarshal_long();
/*  148 */       this.child_bag_id_list.add(Long.valueOf(_v_));
/*      */     }
/*  150 */     this.show_child_id = _os_.unmarshal_long();
/*  151 */     this.signal_way_child_score = _os_.unmarshal_int();
/*  152 */     this.show_child_period = _os_.unmarshal_int();
/*  153 */     this.fashion_info.unmarshal(_os_);
/*  154 */     this.total_rating = _os_.unmarshal_int();
/*  155 */     this.total_discard_child_num = _os_.unmarshal_int();
/*  156 */     this.period_recall_times = _os_.unmarshal_int();
/*  157 */     this.recall_period_refresh_time = _os_.unmarshal_long();
/*  158 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  164 */     _xdb_verify_unsafe_();
/*  165 */     int _size_ = 0;
/*  166 */     for (Long _v_ : this.child_id_list)
/*      */     {
/*  168 */       _size_ += CodedOutputStream.computeInt64Size(1, _v_.longValue());
/*      */     }
/*  170 */     for (Long _v_ : this.child_bag_id_list)
/*      */     {
/*  172 */       _size_ += CodedOutputStream.computeInt64Size(2, _v_.longValue());
/*      */     }
/*  174 */     _size_ += CodedOutputStream.computeInt64Size(3, this.show_child_id);
/*  175 */     _size_ += CodedOutputStream.computeInt32Size(4, this.signal_way_child_score);
/*  176 */     _size_ += CodedOutputStream.computeInt32Size(5, this.show_child_period);
/*  177 */     _size_ += CodedOutputStream.computeMessageSize(6, this.fashion_info);
/*  178 */     _size_ += CodedOutputStream.computeInt32Size(7, this.total_rating);
/*  179 */     _size_ += CodedOutputStream.computeInt32Size(8, this.total_discard_child_num);
/*  180 */     _size_ += CodedOutputStream.computeInt32Size(9, this.period_recall_times);
/*  181 */     _size_ += CodedOutputStream.computeInt64Size(10, this.recall_period_refresh_time);
/*  182 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  188 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  191 */       for (Long _v_ : this.child_id_list)
/*      */       {
/*  193 */         _output_.writeInt64(1, _v_.longValue());
/*      */       }
/*  195 */       for (Long _v_ : this.child_bag_id_list)
/*      */       {
/*  197 */         _output_.writeInt64(2, _v_.longValue());
/*      */       }
/*  199 */       _output_.writeInt64(3, this.show_child_id);
/*  200 */       _output_.writeInt32(4, this.signal_way_child_score);
/*  201 */       _output_.writeInt32(5, this.show_child_period);
/*  202 */       _output_.writeMessage(6, this.fashion_info);
/*  203 */       _output_.writeInt32(7, this.total_rating);
/*  204 */       _output_.writeInt32(8, this.total_discard_child_num);
/*  205 */       _output_.writeInt32(9, this.period_recall_times);
/*  206 */       _output_.writeInt64(10, this.recall_period_refresh_time);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  210 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  212 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  218 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  221 */       boolean done = false;
/*  222 */       while (!done)
/*      */       {
/*  224 */         int tag = _input_.readTag();
/*  225 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  229 */           done = true;
/*  230 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  234 */           long _v_ = 0L;
/*  235 */           _v_ = _input_.readInt64();
/*  236 */           this.child_id_list.add(Long.valueOf(_v_));
/*  237 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  241 */           long _v_ = 0L;
/*  242 */           _v_ = _input_.readInt64();
/*  243 */           this.child_bag_id_list.add(Long.valueOf(_v_));
/*  244 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  248 */           this.show_child_id = _input_.readInt64();
/*  249 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  253 */           this.signal_way_child_score = _input_.readInt32();
/*  254 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  258 */           this.show_child_period = _input_.readInt32();
/*  259 */           break;
/*      */         
/*      */ 
/*      */         case 50: 
/*  263 */           _input_.readMessage(this.fashion_info);
/*  264 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  268 */           this.total_rating = _input_.readInt32();
/*  269 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  273 */           this.total_discard_child_num = _input_.readInt32();
/*  274 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  278 */           this.period_recall_times = _input_.readInt32();
/*  279 */           break;
/*      */         
/*      */ 
/*      */         case 80: 
/*  283 */           this.recall_period_refresh_time = _input_.readInt64();
/*  284 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  288 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  290 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  299 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  303 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  305 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Role2ChildrenInfo copy()
/*      */   {
/*  311 */     _xdb_verify_unsafe_();
/*  312 */     return new Role2ChildrenInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Role2ChildrenInfo toData()
/*      */   {
/*  318 */     _xdb_verify_unsafe_();
/*  319 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Role2ChildrenInfo toBean()
/*      */   {
/*  324 */     _xdb_verify_unsafe_();
/*  325 */     return new Role2ChildrenInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Role2ChildrenInfo toDataIf()
/*      */   {
/*  331 */     _xdb_verify_unsafe_();
/*  332 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Role2ChildrenInfo toBeanIf()
/*      */   {
/*  337 */     _xdb_verify_unsafe_();
/*  338 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  344 */     _xdb_verify_unsafe_();
/*  345 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Long> getChild_id_list()
/*      */   {
/*  352 */     _xdb_verify_unsafe_();
/*  353 */     return Logs.logList(new LogKey(this, "child_id_list"), this.child_id_list);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getChild_id_listAsData()
/*      */   {
/*  359 */     _xdb_verify_unsafe_();
/*      */     
/*  361 */     Role2ChildrenInfo _o_ = this;
/*  362 */     List<Long> child_id_list = new ArrayList();
/*  363 */     child_id_list.addAll(_o_.child_id_list);
/*  364 */     return child_id_list;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Long> getChild_bag_id_list()
/*      */   {
/*  371 */     _xdb_verify_unsafe_();
/*  372 */     return Logs.logList(new LogKey(this, "child_bag_id_list"), this.child_bag_id_list);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getChild_bag_id_listAsData()
/*      */   {
/*  378 */     _xdb_verify_unsafe_();
/*      */     
/*  380 */     Role2ChildrenInfo _o_ = this;
/*  381 */     List<Long> child_bag_id_list = new ArrayList();
/*  382 */     child_bag_id_list.addAll(_o_.child_bag_id_list);
/*  383 */     return child_bag_id_list;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getShow_child_id()
/*      */   {
/*  390 */     _xdb_verify_unsafe_();
/*  391 */     return this.show_child_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getSignal_way_child_score()
/*      */   {
/*  398 */     _xdb_verify_unsafe_();
/*  399 */     return this.signal_way_child_score;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getShow_child_period()
/*      */   {
/*  406 */     _xdb_verify_unsafe_();
/*  407 */     return this.show_child_period;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.ChildFashionInfo getFashion_info()
/*      */   {
/*  414 */     _xdb_verify_unsafe_();
/*  415 */     return this.fashion_info;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getTotal_rating()
/*      */   {
/*  422 */     _xdb_verify_unsafe_();
/*  423 */     return this.total_rating;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getTotal_discard_child_num()
/*      */   {
/*  430 */     _xdb_verify_unsafe_();
/*  431 */     return this.total_discard_child_num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPeriod_recall_times()
/*      */   {
/*  438 */     _xdb_verify_unsafe_();
/*  439 */     return this.period_recall_times;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getRecall_period_refresh_time()
/*      */   {
/*  446 */     _xdb_verify_unsafe_();
/*  447 */     return this.recall_period_refresh_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setShow_child_id(long _v_)
/*      */   {
/*  454 */     _xdb_verify_unsafe_();
/*  455 */     Logs.logIf(new LogKey(this, "show_child_id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  459 */         new LogLong(this, Role2ChildrenInfo.this.show_child_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  463 */             Role2ChildrenInfo.this.show_child_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  467 */     });
/*  468 */     this.show_child_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSignal_way_child_score(int _v_)
/*      */   {
/*  475 */     _xdb_verify_unsafe_();
/*  476 */     Logs.logIf(new LogKey(this, "signal_way_child_score")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  480 */         new LogInt(this, Role2ChildrenInfo.this.signal_way_child_score)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  484 */             Role2ChildrenInfo.this.signal_way_child_score = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  488 */     });
/*  489 */     this.signal_way_child_score = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setShow_child_period(int _v_)
/*      */   {
/*  496 */     _xdb_verify_unsafe_();
/*  497 */     Logs.logIf(new LogKey(this, "show_child_period")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  501 */         new LogInt(this, Role2ChildrenInfo.this.show_child_period)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  505 */             Role2ChildrenInfo.this.show_child_period = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  509 */     });
/*  510 */     this.show_child_period = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTotal_rating(int _v_)
/*      */   {
/*  517 */     _xdb_verify_unsafe_();
/*  518 */     Logs.logIf(new LogKey(this, "total_rating")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  522 */         new LogInt(this, Role2ChildrenInfo.this.total_rating)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  526 */             Role2ChildrenInfo.this.total_rating = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  530 */     });
/*  531 */     this.total_rating = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTotal_discard_child_num(int _v_)
/*      */   {
/*  538 */     _xdb_verify_unsafe_();
/*  539 */     Logs.logIf(new LogKey(this, "total_discard_child_num")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  543 */         new LogInt(this, Role2ChildrenInfo.this.total_discard_child_num)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  547 */             Role2ChildrenInfo.this.total_discard_child_num = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  551 */     });
/*  552 */     this.total_discard_child_num = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPeriod_recall_times(int _v_)
/*      */   {
/*  559 */     _xdb_verify_unsafe_();
/*  560 */     Logs.logIf(new LogKey(this, "period_recall_times")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  564 */         new LogInt(this, Role2ChildrenInfo.this.period_recall_times)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  568 */             Role2ChildrenInfo.this.period_recall_times = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  572 */     });
/*  573 */     this.period_recall_times = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRecall_period_refresh_time(long _v_)
/*      */   {
/*  580 */     _xdb_verify_unsafe_();
/*  581 */     Logs.logIf(new LogKey(this, "recall_period_refresh_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  585 */         new LogLong(this, Role2ChildrenInfo.this.recall_period_refresh_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  589 */             Role2ChildrenInfo.this.recall_period_refresh_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  593 */     });
/*  594 */     this.recall_period_refresh_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  600 */     _xdb_verify_unsafe_();
/*  601 */     Role2ChildrenInfo _o_ = null;
/*  602 */     if ((_o1_ instanceof Role2ChildrenInfo)) { _o_ = (Role2ChildrenInfo)_o1_;
/*  603 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  604 */       return false;
/*  605 */     if (!this.child_id_list.equals(_o_.child_id_list)) return false;
/*  606 */     if (!this.child_bag_id_list.equals(_o_.child_bag_id_list)) return false;
/*  607 */     if (this.show_child_id != _o_.show_child_id) return false;
/*  608 */     if (this.signal_way_child_score != _o_.signal_way_child_score) return false;
/*  609 */     if (this.show_child_period != _o_.show_child_period) return false;
/*  610 */     if (!this.fashion_info.equals(_o_.fashion_info)) return false;
/*  611 */     if (this.total_rating != _o_.total_rating) return false;
/*  612 */     if (this.total_discard_child_num != _o_.total_discard_child_num) return false;
/*  613 */     if (this.period_recall_times != _o_.period_recall_times) return false;
/*  614 */     if (this.recall_period_refresh_time != _o_.recall_period_refresh_time) return false;
/*  615 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  621 */     _xdb_verify_unsafe_();
/*  622 */     int _h_ = 0;
/*  623 */     _h_ += this.child_id_list.hashCode();
/*  624 */     _h_ += this.child_bag_id_list.hashCode();
/*  625 */     _h_ = (int)(_h_ + this.show_child_id);
/*  626 */     _h_ += this.signal_way_child_score;
/*  627 */     _h_ += this.show_child_period;
/*  628 */     _h_ += this.fashion_info.hashCode();
/*  629 */     _h_ += this.total_rating;
/*  630 */     _h_ += this.total_discard_child_num;
/*  631 */     _h_ += this.period_recall_times;
/*  632 */     _h_ = (int)(_h_ + this.recall_period_refresh_time);
/*  633 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  639 */     _xdb_verify_unsafe_();
/*  640 */     StringBuilder _sb_ = new StringBuilder();
/*  641 */     _sb_.append("(");
/*  642 */     _sb_.append(this.child_id_list);
/*  643 */     _sb_.append(",");
/*  644 */     _sb_.append(this.child_bag_id_list);
/*  645 */     _sb_.append(",");
/*  646 */     _sb_.append(this.show_child_id);
/*  647 */     _sb_.append(",");
/*  648 */     _sb_.append(this.signal_way_child_score);
/*  649 */     _sb_.append(",");
/*  650 */     _sb_.append(this.show_child_period);
/*  651 */     _sb_.append(",");
/*  652 */     _sb_.append(this.fashion_info);
/*  653 */     _sb_.append(",");
/*  654 */     _sb_.append(this.total_rating);
/*  655 */     _sb_.append(",");
/*  656 */     _sb_.append(this.total_discard_child_num);
/*  657 */     _sb_.append(",");
/*  658 */     _sb_.append(this.period_recall_times);
/*  659 */     _sb_.append(",");
/*  660 */     _sb_.append(this.recall_period_refresh_time);
/*  661 */     _sb_.append(")");
/*  662 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  668 */     ListenableBean lb = new ListenableBean();
/*  669 */     lb.add(new ListenableChanged().setVarName("child_id_list"));
/*  670 */     lb.add(new ListenableChanged().setVarName("child_bag_id_list"));
/*  671 */     lb.add(new ListenableChanged().setVarName("show_child_id"));
/*  672 */     lb.add(new ListenableChanged().setVarName("signal_way_child_score"));
/*  673 */     lb.add(new ListenableChanged().setVarName("show_child_period"));
/*  674 */     lb.add(new ListenableChanged().setVarName("fashion_info"));
/*  675 */     lb.add(new ListenableChanged().setVarName("total_rating"));
/*  676 */     lb.add(new ListenableChanged().setVarName("total_discard_child_num"));
/*  677 */     lb.add(new ListenableChanged().setVarName("period_recall_times"));
/*  678 */     lb.add(new ListenableChanged().setVarName("recall_period_refresh_time"));
/*  679 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.Role2ChildrenInfo {
/*      */     private Const() {}
/*      */     
/*      */     Role2ChildrenInfo nThis() {
/*  686 */       return Role2ChildrenInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  692 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2ChildrenInfo copy()
/*      */     {
/*  698 */       return Role2ChildrenInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2ChildrenInfo toData()
/*      */     {
/*  704 */       return Role2ChildrenInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.Role2ChildrenInfo toBean()
/*      */     {
/*  709 */       return Role2ChildrenInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2ChildrenInfo toDataIf()
/*      */     {
/*  715 */       return Role2ChildrenInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.Role2ChildrenInfo toBeanIf()
/*      */     {
/*  720 */       return Role2ChildrenInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getChild_id_list()
/*      */     {
/*  727 */       Role2ChildrenInfo.this._xdb_verify_unsafe_();
/*  728 */       return Consts.constList(Role2ChildrenInfo.this.child_id_list);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getChild_id_listAsData()
/*      */     {
/*  734 */       Role2ChildrenInfo.this._xdb_verify_unsafe_();
/*      */       
/*  736 */       Role2ChildrenInfo _o_ = Role2ChildrenInfo.this;
/*  737 */       List<Long> child_id_list = new ArrayList();
/*  738 */       child_id_list.addAll(_o_.child_id_list);
/*  739 */       return child_id_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getChild_bag_id_list()
/*      */     {
/*  746 */       Role2ChildrenInfo.this._xdb_verify_unsafe_();
/*  747 */       return Consts.constList(Role2ChildrenInfo.this.child_bag_id_list);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getChild_bag_id_listAsData()
/*      */     {
/*  753 */       Role2ChildrenInfo.this._xdb_verify_unsafe_();
/*      */       
/*  755 */       Role2ChildrenInfo _o_ = Role2ChildrenInfo.this;
/*  756 */       List<Long> child_bag_id_list = new ArrayList();
/*  757 */       child_bag_id_list.addAll(_o_.child_bag_id_list);
/*  758 */       return child_bag_id_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getShow_child_id()
/*      */     {
/*  765 */       Role2ChildrenInfo.this._xdb_verify_unsafe_();
/*  766 */       return Role2ChildrenInfo.this.show_child_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getSignal_way_child_score()
/*      */     {
/*  773 */       Role2ChildrenInfo.this._xdb_verify_unsafe_();
/*  774 */       return Role2ChildrenInfo.this.signal_way_child_score;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getShow_child_period()
/*      */     {
/*  781 */       Role2ChildrenInfo.this._xdb_verify_unsafe_();
/*  782 */       return Role2ChildrenInfo.this.show_child_period;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.ChildFashionInfo getFashion_info()
/*      */     {
/*  789 */       Role2ChildrenInfo.this._xdb_verify_unsafe_();
/*  790 */       return (xbean.ChildFashionInfo)Consts.toConst(Role2ChildrenInfo.this.fashion_info);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTotal_rating()
/*      */     {
/*  797 */       Role2ChildrenInfo.this._xdb_verify_unsafe_();
/*  798 */       return Role2ChildrenInfo.this.total_rating;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTotal_discard_child_num()
/*      */     {
/*  805 */       Role2ChildrenInfo.this._xdb_verify_unsafe_();
/*  806 */       return Role2ChildrenInfo.this.total_discard_child_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPeriod_recall_times()
/*      */     {
/*  813 */       Role2ChildrenInfo.this._xdb_verify_unsafe_();
/*  814 */       return Role2ChildrenInfo.this.period_recall_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRecall_period_refresh_time()
/*      */     {
/*  821 */       Role2ChildrenInfo.this._xdb_verify_unsafe_();
/*  822 */       return Role2ChildrenInfo.this.recall_period_refresh_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setShow_child_id(long _v_)
/*      */     {
/*  829 */       Role2ChildrenInfo.this._xdb_verify_unsafe_();
/*  830 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSignal_way_child_score(int _v_)
/*      */     {
/*  837 */       Role2ChildrenInfo.this._xdb_verify_unsafe_();
/*  838 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setShow_child_period(int _v_)
/*      */     {
/*  845 */       Role2ChildrenInfo.this._xdb_verify_unsafe_();
/*  846 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotal_rating(int _v_)
/*      */     {
/*  853 */       Role2ChildrenInfo.this._xdb_verify_unsafe_();
/*  854 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotal_discard_child_num(int _v_)
/*      */     {
/*  861 */       Role2ChildrenInfo.this._xdb_verify_unsafe_();
/*  862 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPeriod_recall_times(int _v_)
/*      */     {
/*  869 */       Role2ChildrenInfo.this._xdb_verify_unsafe_();
/*  870 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRecall_period_refresh_time(long _v_)
/*      */     {
/*  877 */       Role2ChildrenInfo.this._xdb_verify_unsafe_();
/*  878 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/*  884 */       Role2ChildrenInfo.this._xdb_verify_unsafe_();
/*  885 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  891 */       Role2ChildrenInfo.this._xdb_verify_unsafe_();
/*  892 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  898 */       return Role2ChildrenInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  904 */       return Role2ChildrenInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  910 */       Role2ChildrenInfo.this._xdb_verify_unsafe_();
/*  911 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  917 */       return Role2ChildrenInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  923 */       return Role2ChildrenInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  929 */       Role2ChildrenInfo.this._xdb_verify_unsafe_();
/*  930 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/*  936 */       return Role2ChildrenInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  942 */       return Role2ChildrenInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  948 */       return Role2ChildrenInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  954 */       return Role2ChildrenInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  960 */       return Role2ChildrenInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  966 */       return Role2ChildrenInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  972 */       return Role2ChildrenInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.Role2ChildrenInfo
/*      */   {
/*      */     private ArrayList<Long> child_id_list;
/*      */     
/*      */     private ArrayList<Long> child_bag_id_list;
/*      */     
/*      */     private long show_child_id;
/*      */     
/*      */     private int signal_way_child_score;
/*      */     
/*      */     private int show_child_period;
/*      */     
/*      */     private xbean.ChildFashionInfo fashion_info;
/*      */     
/*      */     private int total_rating;
/*      */     
/*      */     private int total_discard_child_num;
/*      */     
/*      */     private int period_recall_times;
/*      */     
/*      */     private long recall_period_refresh_time;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1002 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 1007 */       this.child_id_list = new ArrayList();
/* 1008 */       this.child_bag_id_list = new ArrayList();
/* 1009 */       this.show_child_id = -1L;
/* 1010 */       this.fashion_info = new ChildFashionInfo.Data();
/*      */     }
/*      */     
/*      */     Data(xbean.Role2ChildrenInfo _o1_)
/*      */     {
/* 1015 */       if ((_o1_ instanceof Role2ChildrenInfo)) { assign((Role2ChildrenInfo)_o1_);
/* 1016 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 1017 */       } else if ((_o1_ instanceof Role2ChildrenInfo.Const)) assign(((Role2ChildrenInfo.Const)_o1_).nThis()); else {
/* 1018 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Role2ChildrenInfo _o_) {
/* 1023 */       this.child_id_list = new ArrayList();
/* 1024 */       this.child_id_list.addAll(_o_.child_id_list);
/* 1025 */       this.child_bag_id_list = new ArrayList();
/* 1026 */       this.child_bag_id_list.addAll(_o_.child_bag_id_list);
/* 1027 */       this.show_child_id = _o_.show_child_id;
/* 1028 */       this.signal_way_child_score = _o_.signal_way_child_score;
/* 1029 */       this.show_child_period = _o_.show_child_period;
/* 1030 */       this.fashion_info = new ChildFashionInfo.Data(_o_.fashion_info);
/* 1031 */       this.total_rating = _o_.total_rating;
/* 1032 */       this.total_discard_child_num = _o_.total_discard_child_num;
/* 1033 */       this.period_recall_times = _o_.period_recall_times;
/* 1034 */       this.recall_period_refresh_time = _o_.recall_period_refresh_time;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/* 1039 */       this.child_id_list = new ArrayList();
/* 1040 */       this.child_id_list.addAll(_o_.child_id_list);
/* 1041 */       this.child_bag_id_list = new ArrayList();
/* 1042 */       this.child_bag_id_list.addAll(_o_.child_bag_id_list);
/* 1043 */       this.show_child_id = _o_.show_child_id;
/* 1044 */       this.signal_way_child_score = _o_.signal_way_child_score;
/* 1045 */       this.show_child_period = _o_.show_child_period;
/* 1046 */       this.fashion_info = new ChildFashionInfo.Data(_o_.fashion_info);
/* 1047 */       this.total_rating = _o_.total_rating;
/* 1048 */       this.total_discard_child_num = _o_.total_discard_child_num;
/* 1049 */       this.period_recall_times = _o_.period_recall_times;
/* 1050 */       this.recall_period_refresh_time = _o_.recall_period_refresh_time;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1056 */       _os_.compact_uint32(this.child_id_list.size());
/* 1057 */       for (Long _v_ : this.child_id_list)
/*      */       {
/* 1059 */         _os_.marshal(_v_.longValue());
/*      */       }
/* 1061 */       _os_.compact_uint32(this.child_bag_id_list.size());
/* 1062 */       for (Long _v_ : this.child_bag_id_list)
/*      */       {
/* 1064 */         _os_.marshal(_v_.longValue());
/*      */       }
/* 1066 */       _os_.marshal(this.show_child_id);
/* 1067 */       _os_.marshal(this.signal_way_child_score);
/* 1068 */       _os_.marshal(this.show_child_period);
/* 1069 */       this.fashion_info.marshal(_os_);
/* 1070 */       _os_.marshal(this.total_rating);
/* 1071 */       _os_.marshal(this.total_discard_child_num);
/* 1072 */       _os_.marshal(this.period_recall_times);
/* 1073 */       _os_.marshal(this.recall_period_refresh_time);
/* 1074 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1080 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1082 */         long _v_ = 0L;
/* 1083 */         _v_ = _os_.unmarshal_long();
/* 1084 */         this.child_id_list.add(Long.valueOf(_v_));
/*      */       }
/* 1086 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1088 */         long _v_ = 0L;
/* 1089 */         _v_ = _os_.unmarshal_long();
/* 1090 */         this.child_bag_id_list.add(Long.valueOf(_v_));
/*      */       }
/* 1092 */       this.show_child_id = _os_.unmarshal_long();
/* 1093 */       this.signal_way_child_score = _os_.unmarshal_int();
/* 1094 */       this.show_child_period = _os_.unmarshal_int();
/* 1095 */       this.fashion_info.unmarshal(_os_);
/* 1096 */       this.total_rating = _os_.unmarshal_int();
/* 1097 */       this.total_discard_child_num = _os_.unmarshal_int();
/* 1098 */       this.period_recall_times = _os_.unmarshal_int();
/* 1099 */       this.recall_period_refresh_time = _os_.unmarshal_long();
/* 1100 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1106 */       int _size_ = 0;
/* 1107 */       for (Long _v_ : this.child_id_list)
/*      */       {
/* 1109 */         _size_ += CodedOutputStream.computeInt64Size(1, _v_.longValue());
/*      */       }
/* 1111 */       for (Long _v_ : this.child_bag_id_list)
/*      */       {
/* 1113 */         _size_ += CodedOutputStream.computeInt64Size(2, _v_.longValue());
/*      */       }
/* 1115 */       _size_ += CodedOutputStream.computeInt64Size(3, this.show_child_id);
/* 1116 */       _size_ += CodedOutputStream.computeInt32Size(4, this.signal_way_child_score);
/* 1117 */       _size_ += CodedOutputStream.computeInt32Size(5, this.show_child_period);
/* 1118 */       _size_ += CodedOutputStream.computeMessageSize(6, this.fashion_info);
/* 1119 */       _size_ += CodedOutputStream.computeInt32Size(7, this.total_rating);
/* 1120 */       _size_ += CodedOutputStream.computeInt32Size(8, this.total_discard_child_num);
/* 1121 */       _size_ += CodedOutputStream.computeInt32Size(9, this.period_recall_times);
/* 1122 */       _size_ += CodedOutputStream.computeInt64Size(10, this.recall_period_refresh_time);
/* 1123 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1131 */         for (Long _v_ : this.child_id_list)
/*      */         {
/* 1133 */           _output_.writeInt64(1, _v_.longValue());
/*      */         }
/* 1135 */         for (Long _v_ : this.child_bag_id_list)
/*      */         {
/* 1137 */           _output_.writeInt64(2, _v_.longValue());
/*      */         }
/* 1139 */         _output_.writeInt64(3, this.show_child_id);
/* 1140 */         _output_.writeInt32(4, this.signal_way_child_score);
/* 1141 */         _output_.writeInt32(5, this.show_child_period);
/* 1142 */         _output_.writeMessage(6, this.fashion_info);
/* 1143 */         _output_.writeInt32(7, this.total_rating);
/* 1144 */         _output_.writeInt32(8, this.total_discard_child_num);
/* 1145 */         _output_.writeInt32(9, this.period_recall_times);
/* 1146 */         _output_.writeInt64(10, this.recall_period_refresh_time);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1150 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1152 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1160 */         boolean done = false;
/* 1161 */         while (!done)
/*      */         {
/* 1163 */           int tag = _input_.readTag();
/* 1164 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1168 */             done = true;
/* 1169 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1173 */             long _v_ = 0L;
/* 1174 */             _v_ = _input_.readInt64();
/* 1175 */             this.child_id_list.add(Long.valueOf(_v_));
/* 1176 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1180 */             long _v_ = 0L;
/* 1181 */             _v_ = _input_.readInt64();
/* 1182 */             this.child_bag_id_list.add(Long.valueOf(_v_));
/* 1183 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1187 */             this.show_child_id = _input_.readInt64();
/* 1188 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1192 */             this.signal_way_child_score = _input_.readInt32();
/* 1193 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1197 */             this.show_child_period = _input_.readInt32();
/* 1198 */             break;
/*      */           
/*      */ 
/*      */           case 50: 
/* 1202 */             _input_.readMessage(this.fashion_info);
/* 1203 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1207 */             this.total_rating = _input_.readInt32();
/* 1208 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1212 */             this.total_discard_child_num = _input_.readInt32();
/* 1213 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 1217 */             this.period_recall_times = _input_.readInt32();
/* 1218 */             break;
/*      */           
/*      */ 
/*      */           case 80: 
/* 1222 */             this.recall_period_refresh_time = _input_.readInt64();
/* 1223 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1227 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1229 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1238 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1242 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1244 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2ChildrenInfo copy()
/*      */     {
/* 1250 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2ChildrenInfo toData()
/*      */     {
/* 1256 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.Role2ChildrenInfo toBean()
/*      */     {
/* 1261 */       return new Role2ChildrenInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Role2ChildrenInfo toDataIf()
/*      */     {
/* 1267 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.Role2ChildrenInfo toBeanIf()
/*      */     {
/* 1272 */       return new Role2ChildrenInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1278 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 1282 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1286 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1290 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 1294 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1298 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1302 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getChild_id_list()
/*      */     {
/* 1309 */       return this.child_id_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getChild_id_listAsData()
/*      */     {
/* 1316 */       return this.child_id_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getChild_bag_id_list()
/*      */     {
/* 1323 */       return this.child_bag_id_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getChild_bag_id_listAsData()
/*      */     {
/* 1330 */       return this.child_bag_id_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getShow_child_id()
/*      */     {
/* 1337 */       return this.show_child_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getSignal_way_child_score()
/*      */     {
/* 1344 */       return this.signal_way_child_score;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getShow_child_period()
/*      */     {
/* 1351 */       return this.show_child_period;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.ChildFashionInfo getFashion_info()
/*      */     {
/* 1358 */       return this.fashion_info;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTotal_rating()
/*      */     {
/* 1365 */       return this.total_rating;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTotal_discard_child_num()
/*      */     {
/* 1372 */       return this.total_discard_child_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPeriod_recall_times()
/*      */     {
/* 1379 */       return this.period_recall_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRecall_period_refresh_time()
/*      */     {
/* 1386 */       return this.recall_period_refresh_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setShow_child_id(long _v_)
/*      */     {
/* 1393 */       this.show_child_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSignal_way_child_score(int _v_)
/*      */     {
/* 1400 */       this.signal_way_child_score = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setShow_child_period(int _v_)
/*      */     {
/* 1407 */       this.show_child_period = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotal_rating(int _v_)
/*      */     {
/* 1414 */       this.total_rating = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotal_discard_child_num(int _v_)
/*      */     {
/* 1421 */       this.total_discard_child_num = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPeriod_recall_times(int _v_)
/*      */     {
/* 1428 */       this.period_recall_times = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRecall_period_refresh_time(long _v_)
/*      */     {
/* 1435 */       this.recall_period_refresh_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1441 */       if (!(_o1_ instanceof Data)) return false;
/* 1442 */       Data _o_ = (Data)_o1_;
/* 1443 */       if (!this.child_id_list.equals(_o_.child_id_list)) return false;
/* 1444 */       if (!this.child_bag_id_list.equals(_o_.child_bag_id_list)) return false;
/* 1445 */       if (this.show_child_id != _o_.show_child_id) return false;
/* 1446 */       if (this.signal_way_child_score != _o_.signal_way_child_score) return false;
/* 1447 */       if (this.show_child_period != _o_.show_child_period) return false;
/* 1448 */       if (!this.fashion_info.equals(_o_.fashion_info)) return false;
/* 1449 */       if (this.total_rating != _o_.total_rating) return false;
/* 1450 */       if (this.total_discard_child_num != _o_.total_discard_child_num) return false;
/* 1451 */       if (this.period_recall_times != _o_.period_recall_times) return false;
/* 1452 */       if (this.recall_period_refresh_time != _o_.recall_period_refresh_time) return false;
/* 1453 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1459 */       int _h_ = 0;
/* 1460 */       _h_ += this.child_id_list.hashCode();
/* 1461 */       _h_ += this.child_bag_id_list.hashCode();
/* 1462 */       _h_ = (int)(_h_ + this.show_child_id);
/* 1463 */       _h_ += this.signal_way_child_score;
/* 1464 */       _h_ += this.show_child_period;
/* 1465 */       _h_ += this.fashion_info.hashCode();
/* 1466 */       _h_ += this.total_rating;
/* 1467 */       _h_ += this.total_discard_child_num;
/* 1468 */       _h_ += this.period_recall_times;
/* 1469 */       _h_ = (int)(_h_ + this.recall_period_refresh_time);
/* 1470 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1476 */       StringBuilder _sb_ = new StringBuilder();
/* 1477 */       _sb_.append("(");
/* 1478 */       _sb_.append(this.child_id_list);
/* 1479 */       _sb_.append(",");
/* 1480 */       _sb_.append(this.child_bag_id_list);
/* 1481 */       _sb_.append(",");
/* 1482 */       _sb_.append(this.show_child_id);
/* 1483 */       _sb_.append(",");
/* 1484 */       _sb_.append(this.signal_way_child_score);
/* 1485 */       _sb_.append(",");
/* 1486 */       _sb_.append(this.show_child_period);
/* 1487 */       _sb_.append(",");
/* 1488 */       _sb_.append(this.fashion_info);
/* 1489 */       _sb_.append(",");
/* 1490 */       _sb_.append(this.total_rating);
/* 1491 */       _sb_.append(",");
/* 1492 */       _sb_.append(this.total_discard_child_num);
/* 1493 */       _sb_.append(",");
/* 1494 */       _sb_.append(this.period_recall_times);
/* 1495 */       _sb_.append(",");
/* 1496 */       _sb_.append(this.recall_period_refresh_time);
/* 1497 */       _sb_.append(")");
/* 1498 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Role2ChildrenInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */