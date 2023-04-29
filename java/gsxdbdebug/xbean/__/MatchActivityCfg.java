/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.MarshalException;
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xbean.MatchKey;
/*      */ import xdb.Bean;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.Listenable;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.logs.LogLong;
/*      */ import xdb.logs.LogObject;
/*      */ 
/*      */ public final class MatchActivityCfg
/*      */   extends XBean implements xbean.MatchActivityCfg
/*      */ {
/*      */   private MatchKey activity;
/*      */   private int matchtype;
/*      */   private long starttime;
/*      */   private int rolelevel;
/*      */   private int levellow;
/*      */   private int levelhigh;
/*      */   private int needlevellow;
/*      */   private int needlevelhigh;
/*      */   private long insistwaitsessionid;
/*      */   private long beremovedsessionid;
/*      */   private long expandlvsessionid;
/*      */   private long rolebeleaderhintsessionid;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   40 */     this.activity = new MatchKey();
/*   41 */     this.matchtype = 0;
/*   42 */     this.starttime = 0L;
/*   43 */     this.rolelevel = 0;
/*   44 */     this.levellow = 0;
/*   45 */     this.levelhigh = 0;
/*   46 */     this.needlevellow = 0;
/*   47 */     this.needlevelhigh = 0;
/*   48 */     this.insistwaitsessionid = 0L;
/*   49 */     this.beremovedsessionid = 0L;
/*   50 */     this.expandlvsessionid = 0L;
/*   51 */     this.rolebeleaderhintsessionid = 0L;
/*      */   }
/*      */   
/*      */   MatchActivityCfg(int __, XBean _xp_, String _vn_)
/*      */   {
/*   56 */     super(_xp_, _vn_);
/*   57 */     this.activity = new MatchKey();
/*      */   }
/*      */   
/*      */   public MatchActivityCfg()
/*      */   {
/*   62 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public MatchActivityCfg(MatchActivityCfg _o_)
/*      */   {
/*   67 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   MatchActivityCfg(xbean.MatchActivityCfg _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   72 */     super(_xp_, _vn_);
/*   73 */     if ((_o1_ instanceof MatchActivityCfg)) { assign((MatchActivityCfg)_o1_);
/*   74 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   75 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   76 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(MatchActivityCfg _o_) {
/*   81 */     _o_._xdb_verify_unsafe_();
/*   82 */     this.activity = _o_.activity;
/*   83 */     this.matchtype = _o_.matchtype;
/*   84 */     this.starttime = _o_.starttime;
/*   85 */     this.rolelevel = _o_.rolelevel;
/*   86 */     this.levellow = _o_.levellow;
/*   87 */     this.levelhigh = _o_.levelhigh;
/*   88 */     this.needlevellow = _o_.needlevellow;
/*   89 */     this.needlevelhigh = _o_.needlevelhigh;
/*   90 */     this.insistwaitsessionid = _o_.insistwaitsessionid;
/*   91 */     this.beremovedsessionid = _o_.beremovedsessionid;
/*   92 */     this.expandlvsessionid = _o_.expandlvsessionid;
/*   93 */     this.rolebeleaderhintsessionid = _o_.rolebeleaderhintsessionid;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   98 */     this.activity = _o_.activity;
/*   99 */     this.matchtype = _o_.matchtype;
/*  100 */     this.starttime = _o_.starttime;
/*  101 */     this.rolelevel = _o_.rolelevel;
/*  102 */     this.levellow = _o_.levellow;
/*  103 */     this.levelhigh = _o_.levelhigh;
/*  104 */     this.needlevellow = _o_.needlevellow;
/*  105 */     this.needlevelhigh = _o_.needlevelhigh;
/*  106 */     this.insistwaitsessionid = _o_.insistwaitsessionid;
/*  107 */     this.beremovedsessionid = _o_.beremovedsessionid;
/*  108 */     this.expandlvsessionid = _o_.expandlvsessionid;
/*  109 */     this.rolebeleaderhintsessionid = _o_.rolebeleaderhintsessionid;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  115 */     _xdb_verify_unsafe_();
/*  116 */     this.activity.marshal(_os_);
/*  117 */     _os_.marshal(this.matchtype);
/*  118 */     _os_.marshal(this.starttime);
/*  119 */     _os_.marshal(this.rolelevel);
/*  120 */     _os_.marshal(this.levellow);
/*  121 */     _os_.marshal(this.levelhigh);
/*  122 */     _os_.marshal(this.needlevellow);
/*  123 */     _os_.marshal(this.needlevelhigh);
/*  124 */     _os_.marshal(this.insistwaitsessionid);
/*  125 */     _os_.marshal(this.beremovedsessionid);
/*  126 */     _os_.marshal(this.expandlvsessionid);
/*  127 */     _os_.marshal(this.rolebeleaderhintsessionid);
/*  128 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws MarshalException
/*      */   {
/*  134 */     _xdb_verify_unsafe_();
/*  135 */     this.activity.unmarshal(_os_);
/*  136 */     this.matchtype = _os_.unmarshal_int();
/*  137 */     this.starttime = _os_.unmarshal_long();
/*  138 */     this.rolelevel = _os_.unmarshal_int();
/*  139 */     this.levellow = _os_.unmarshal_int();
/*  140 */     this.levelhigh = _os_.unmarshal_int();
/*  141 */     this.needlevellow = _os_.unmarshal_int();
/*  142 */     this.needlevelhigh = _os_.unmarshal_int();
/*  143 */     this.insistwaitsessionid = _os_.unmarshal_long();
/*  144 */     this.beremovedsessionid = _os_.unmarshal_long();
/*  145 */     this.expandlvsessionid = _os_.unmarshal_long();
/*  146 */     this.rolebeleaderhintsessionid = _os_.unmarshal_long();
/*  147 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  153 */     _xdb_verify_unsafe_();
/*  154 */     int _size_ = 0;
/*  155 */     _size_ += CodedOutputStream.computeMessageSize(1, this.activity);
/*  156 */     _size_ += CodedOutputStream.computeInt32Size(2, this.matchtype);
/*  157 */     _size_ += CodedOutputStream.computeInt64Size(3, this.starttime);
/*  158 */     _size_ += CodedOutputStream.computeInt32Size(4, this.rolelevel);
/*  159 */     _size_ += CodedOutputStream.computeInt32Size(5, this.levellow);
/*  160 */     _size_ += CodedOutputStream.computeInt32Size(6, this.levelhigh);
/*  161 */     _size_ += CodedOutputStream.computeInt32Size(7, this.needlevellow);
/*  162 */     _size_ += CodedOutputStream.computeInt32Size(8, this.needlevelhigh);
/*  163 */     _size_ += CodedOutputStream.computeInt64Size(9, this.insistwaitsessionid);
/*  164 */     _size_ += CodedOutputStream.computeInt64Size(10, this.beremovedsessionid);
/*  165 */     _size_ += CodedOutputStream.computeInt64Size(11, this.expandlvsessionid);
/*  166 */     _size_ += CodedOutputStream.computeInt64Size(12, this.rolebeleaderhintsessionid);
/*  167 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  173 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  176 */       _output_.writeMessage(1, this.activity);
/*  177 */       _output_.writeInt32(2, this.matchtype);
/*  178 */       _output_.writeInt64(3, this.starttime);
/*  179 */       _output_.writeInt32(4, this.rolelevel);
/*  180 */       _output_.writeInt32(5, this.levellow);
/*  181 */       _output_.writeInt32(6, this.levelhigh);
/*  182 */       _output_.writeInt32(7, this.needlevellow);
/*  183 */       _output_.writeInt32(8, this.needlevelhigh);
/*  184 */       _output_.writeInt64(9, this.insistwaitsessionid);
/*  185 */       _output_.writeInt64(10, this.beremovedsessionid);
/*  186 */       _output_.writeInt64(11, this.expandlvsessionid);
/*  187 */       _output_.writeInt64(12, this.rolebeleaderhintsessionid);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  191 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  193 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  199 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  202 */       boolean done = false;
/*  203 */       while (!done)
/*      */       {
/*  205 */         int tag = _input_.readTag();
/*  206 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  210 */           done = true;
/*  211 */           break;
/*      */         
/*      */ 
/*      */         case 10: 
/*  215 */           _input_.readMessage(this.activity);
/*  216 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  220 */           this.matchtype = _input_.readInt32();
/*  221 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  225 */           this.starttime = _input_.readInt64();
/*  226 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  230 */           this.rolelevel = _input_.readInt32();
/*  231 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  235 */           this.levellow = _input_.readInt32();
/*  236 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  240 */           this.levelhigh = _input_.readInt32();
/*  241 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  245 */           this.needlevellow = _input_.readInt32();
/*  246 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  250 */           this.needlevelhigh = _input_.readInt32();
/*  251 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  255 */           this.insistwaitsessionid = _input_.readInt64();
/*  256 */           break;
/*      */         
/*      */ 
/*      */         case 80: 
/*  260 */           this.beremovedsessionid = _input_.readInt64();
/*  261 */           break;
/*      */         
/*      */ 
/*      */         case 88: 
/*  265 */           this.expandlvsessionid = _input_.readInt64();
/*  266 */           break;
/*      */         
/*      */ 
/*      */         case 96: 
/*  270 */           this.rolebeleaderhintsessionid = _input_.readInt64();
/*  271 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  275 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  277 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  286 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  290 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  292 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MatchActivityCfg copy()
/*      */   {
/*  298 */     _xdb_verify_unsafe_();
/*  299 */     return new MatchActivityCfg(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MatchActivityCfg toData()
/*      */   {
/*  305 */     _xdb_verify_unsafe_();
/*  306 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.MatchActivityCfg toBean()
/*      */   {
/*  311 */     _xdb_verify_unsafe_();
/*  312 */     return new MatchActivityCfg(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MatchActivityCfg toDataIf()
/*      */   {
/*  318 */     _xdb_verify_unsafe_();
/*  319 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.MatchActivityCfg toBeanIf()
/*      */   {
/*  324 */     _xdb_verify_unsafe_();
/*  325 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  331 */     _xdb_verify_unsafe_();
/*  332 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public MatchKey getActivity()
/*      */   {
/*  339 */     _xdb_verify_unsafe_();
/*  340 */     return this.activity;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getMatchtype()
/*      */   {
/*  347 */     _xdb_verify_unsafe_();
/*  348 */     return this.matchtype;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getStarttime()
/*      */   {
/*  355 */     _xdb_verify_unsafe_();
/*  356 */     return this.starttime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getRolelevel()
/*      */   {
/*  363 */     _xdb_verify_unsafe_();
/*  364 */     return this.rolelevel;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getLevellow()
/*      */   {
/*  371 */     _xdb_verify_unsafe_();
/*  372 */     return this.levellow;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getLevelhigh()
/*      */   {
/*  379 */     _xdb_verify_unsafe_();
/*  380 */     return this.levelhigh;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getNeedlevellow()
/*      */   {
/*  387 */     _xdb_verify_unsafe_();
/*  388 */     return this.needlevellow;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getNeedlevelhigh()
/*      */   {
/*  395 */     _xdb_verify_unsafe_();
/*  396 */     return this.needlevelhigh;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getInsistwaitsessionid()
/*      */   {
/*  403 */     _xdb_verify_unsafe_();
/*  404 */     return this.insistwaitsessionid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getBeremovedsessionid()
/*      */   {
/*  411 */     _xdb_verify_unsafe_();
/*  412 */     return this.beremovedsessionid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getExpandlvsessionid()
/*      */   {
/*  419 */     _xdb_verify_unsafe_();
/*  420 */     return this.expandlvsessionid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getRolebeleaderhintsessionid()
/*      */   {
/*  427 */     _xdb_verify_unsafe_();
/*  428 */     return this.rolebeleaderhintsessionid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setActivity(MatchKey _v_)
/*      */   {
/*  435 */     _xdb_verify_unsafe_();
/*  436 */     Logs.logIf(new LogKey(this, "activity")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  440 */         new LogObject(this, MatchActivityCfg.this.activity)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  444 */             MatchActivityCfg.this.activity = ((MatchKey)this._xdb_saved);
/*      */           }
/*      */         };
/*      */       }
/*  448 */     });
/*  449 */     this.activity = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMatchtype(int _v_)
/*      */   {
/*  456 */     _xdb_verify_unsafe_();
/*  457 */     Logs.logIf(new LogKey(this, "matchtype")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  461 */         new LogInt(this, MatchActivityCfg.this.matchtype)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  465 */             MatchActivityCfg.this.matchtype = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  469 */     });
/*  470 */     this.matchtype = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setStarttime(long _v_)
/*      */   {
/*  477 */     _xdb_verify_unsafe_();
/*  478 */     Logs.logIf(new LogKey(this, "starttime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  482 */         new LogLong(this, MatchActivityCfg.this.starttime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  486 */             MatchActivityCfg.this.starttime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  490 */     });
/*  491 */     this.starttime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRolelevel(int _v_)
/*      */   {
/*  498 */     _xdb_verify_unsafe_();
/*  499 */     Logs.logIf(new LogKey(this, "rolelevel")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  503 */         new LogInt(this, MatchActivityCfg.this.rolelevel)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  507 */             MatchActivityCfg.this.rolelevel = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  511 */     });
/*  512 */     this.rolelevel = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLevellow(int _v_)
/*      */   {
/*  519 */     _xdb_verify_unsafe_();
/*  520 */     Logs.logIf(new LogKey(this, "levellow")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  524 */         new LogInt(this, MatchActivityCfg.this.levellow)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  528 */             MatchActivityCfg.this.levellow = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  532 */     });
/*  533 */     this.levellow = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLevelhigh(int _v_)
/*      */   {
/*  540 */     _xdb_verify_unsafe_();
/*  541 */     Logs.logIf(new LogKey(this, "levelhigh")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  545 */         new LogInt(this, MatchActivityCfg.this.levelhigh)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  549 */             MatchActivityCfg.this.levelhigh = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  553 */     });
/*  554 */     this.levelhigh = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setNeedlevellow(int _v_)
/*      */   {
/*  561 */     _xdb_verify_unsafe_();
/*  562 */     Logs.logIf(new LogKey(this, "needlevellow")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  566 */         new LogInt(this, MatchActivityCfg.this.needlevellow)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  570 */             MatchActivityCfg.this.needlevellow = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  574 */     });
/*  575 */     this.needlevellow = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setNeedlevelhigh(int _v_)
/*      */   {
/*  582 */     _xdb_verify_unsafe_();
/*  583 */     Logs.logIf(new LogKey(this, "needlevelhigh")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  587 */         new LogInt(this, MatchActivityCfg.this.needlevelhigh)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  591 */             MatchActivityCfg.this.needlevelhigh = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  595 */     });
/*  596 */     this.needlevelhigh = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setInsistwaitsessionid(long _v_)
/*      */   {
/*  603 */     _xdb_verify_unsafe_();
/*  604 */     Logs.logIf(new LogKey(this, "insistwaitsessionid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  608 */         new LogLong(this, MatchActivityCfg.this.insistwaitsessionid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  612 */             MatchActivityCfg.this.insistwaitsessionid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  616 */     });
/*  617 */     this.insistwaitsessionid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBeremovedsessionid(long _v_)
/*      */   {
/*  624 */     _xdb_verify_unsafe_();
/*  625 */     Logs.logIf(new LogKey(this, "beremovedsessionid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  629 */         new LogLong(this, MatchActivityCfg.this.beremovedsessionid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  633 */             MatchActivityCfg.this.beremovedsessionid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  637 */     });
/*  638 */     this.beremovedsessionid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setExpandlvsessionid(long _v_)
/*      */   {
/*  645 */     _xdb_verify_unsafe_();
/*  646 */     Logs.logIf(new LogKey(this, "expandlvsessionid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  650 */         new LogLong(this, MatchActivityCfg.this.expandlvsessionid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  654 */             MatchActivityCfg.this.expandlvsessionid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  658 */     });
/*  659 */     this.expandlvsessionid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRolebeleaderhintsessionid(long _v_)
/*      */   {
/*  666 */     _xdb_verify_unsafe_();
/*  667 */     Logs.logIf(new LogKey(this, "rolebeleaderhintsessionid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  671 */         new LogLong(this, MatchActivityCfg.this.rolebeleaderhintsessionid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  675 */             MatchActivityCfg.this.rolebeleaderhintsessionid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  679 */     });
/*  680 */     this.rolebeleaderhintsessionid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  686 */     _xdb_verify_unsafe_();
/*  687 */     MatchActivityCfg _o_ = null;
/*  688 */     if ((_o1_ instanceof MatchActivityCfg)) { _o_ = (MatchActivityCfg)_o1_;
/*  689 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  690 */       return false;
/*  691 */     if (!this.activity.equals(_o_.activity)) return false;
/*  692 */     if (this.matchtype != _o_.matchtype) return false;
/*  693 */     if (this.starttime != _o_.starttime) return false;
/*  694 */     if (this.rolelevel != _o_.rolelevel) return false;
/*  695 */     if (this.levellow != _o_.levellow) return false;
/*  696 */     if (this.levelhigh != _o_.levelhigh) return false;
/*  697 */     if (this.needlevellow != _o_.needlevellow) return false;
/*  698 */     if (this.needlevelhigh != _o_.needlevelhigh) return false;
/*  699 */     if (this.insistwaitsessionid != _o_.insistwaitsessionid) return false;
/*  700 */     if (this.beremovedsessionid != _o_.beremovedsessionid) return false;
/*  701 */     if (this.expandlvsessionid != _o_.expandlvsessionid) return false;
/*  702 */     if (this.rolebeleaderhintsessionid != _o_.rolebeleaderhintsessionid) return false;
/*  703 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  709 */     _xdb_verify_unsafe_();
/*  710 */     int _h_ = 0;
/*  711 */     _h_ += this.activity.hashCode();
/*  712 */     _h_ += this.matchtype;
/*  713 */     _h_ = (int)(_h_ + this.starttime);
/*  714 */     _h_ += this.rolelevel;
/*  715 */     _h_ += this.levellow;
/*  716 */     _h_ += this.levelhigh;
/*  717 */     _h_ += this.needlevellow;
/*  718 */     _h_ += this.needlevelhigh;
/*  719 */     _h_ = (int)(_h_ + this.insistwaitsessionid);
/*  720 */     _h_ = (int)(_h_ + this.beremovedsessionid);
/*  721 */     _h_ = (int)(_h_ + this.expandlvsessionid);
/*  722 */     _h_ = (int)(_h_ + this.rolebeleaderhintsessionid);
/*  723 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  729 */     _xdb_verify_unsafe_();
/*  730 */     StringBuilder _sb_ = new StringBuilder();
/*  731 */     _sb_.append("(");
/*  732 */     _sb_.append(this.activity);
/*  733 */     _sb_.append(",");
/*  734 */     _sb_.append(this.matchtype);
/*  735 */     _sb_.append(",");
/*  736 */     _sb_.append(this.starttime);
/*  737 */     _sb_.append(",");
/*  738 */     _sb_.append(this.rolelevel);
/*  739 */     _sb_.append(",");
/*  740 */     _sb_.append(this.levellow);
/*  741 */     _sb_.append(",");
/*  742 */     _sb_.append(this.levelhigh);
/*  743 */     _sb_.append(",");
/*  744 */     _sb_.append(this.needlevellow);
/*  745 */     _sb_.append(",");
/*  746 */     _sb_.append(this.needlevelhigh);
/*  747 */     _sb_.append(",");
/*  748 */     _sb_.append(this.insistwaitsessionid);
/*  749 */     _sb_.append(",");
/*  750 */     _sb_.append(this.beremovedsessionid);
/*  751 */     _sb_.append(",");
/*  752 */     _sb_.append(this.expandlvsessionid);
/*  753 */     _sb_.append(",");
/*  754 */     _sb_.append(this.rolebeleaderhintsessionid);
/*  755 */     _sb_.append(")");
/*  756 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public Listenable newListenable()
/*      */   {
/*  762 */     ListenableBean lb = new ListenableBean();
/*  763 */     lb.add(new ListenableChanged().setVarName("activity"));
/*  764 */     lb.add(new ListenableChanged().setVarName("matchtype"));
/*  765 */     lb.add(new ListenableChanged().setVarName("starttime"));
/*  766 */     lb.add(new ListenableChanged().setVarName("rolelevel"));
/*  767 */     lb.add(new ListenableChanged().setVarName("levellow"));
/*  768 */     lb.add(new ListenableChanged().setVarName("levelhigh"));
/*  769 */     lb.add(new ListenableChanged().setVarName("needlevellow"));
/*  770 */     lb.add(new ListenableChanged().setVarName("needlevelhigh"));
/*  771 */     lb.add(new ListenableChanged().setVarName("insistwaitsessionid"));
/*  772 */     lb.add(new ListenableChanged().setVarName("beremovedsessionid"));
/*  773 */     lb.add(new ListenableChanged().setVarName("expandlvsessionid"));
/*  774 */     lb.add(new ListenableChanged().setVarName("rolebeleaderhintsessionid"));
/*  775 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.MatchActivityCfg {
/*      */     private Const() {}
/*      */     
/*      */     MatchActivityCfg nThis() {
/*  782 */       return MatchActivityCfg.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  788 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MatchActivityCfg copy()
/*      */     {
/*  794 */       return MatchActivityCfg.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MatchActivityCfg toData()
/*      */     {
/*  800 */       return MatchActivityCfg.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.MatchActivityCfg toBean()
/*      */     {
/*  805 */       return MatchActivityCfg.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MatchActivityCfg toDataIf()
/*      */     {
/*  811 */       return MatchActivityCfg.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.MatchActivityCfg toBeanIf()
/*      */     {
/*  816 */       return MatchActivityCfg.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public MatchKey getActivity()
/*      */     {
/*  823 */       MatchActivityCfg.this._xdb_verify_unsafe_();
/*  824 */       return MatchActivityCfg.this.activity;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMatchtype()
/*      */     {
/*  831 */       MatchActivityCfg.this._xdb_verify_unsafe_();
/*  832 */       return MatchActivityCfg.this.matchtype;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getStarttime()
/*      */     {
/*  839 */       MatchActivityCfg.this._xdb_verify_unsafe_();
/*  840 */       return MatchActivityCfg.this.starttime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRolelevel()
/*      */     {
/*  847 */       MatchActivityCfg.this._xdb_verify_unsafe_();
/*  848 */       return MatchActivityCfg.this.rolelevel;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLevellow()
/*      */     {
/*  855 */       MatchActivityCfg.this._xdb_verify_unsafe_();
/*  856 */       return MatchActivityCfg.this.levellow;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLevelhigh()
/*      */     {
/*  863 */       MatchActivityCfg.this._xdb_verify_unsafe_();
/*  864 */       return MatchActivityCfg.this.levelhigh;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getNeedlevellow()
/*      */     {
/*  871 */       MatchActivityCfg.this._xdb_verify_unsafe_();
/*  872 */       return MatchActivityCfg.this.needlevellow;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getNeedlevelhigh()
/*      */     {
/*  879 */       MatchActivityCfg.this._xdb_verify_unsafe_();
/*  880 */       return MatchActivityCfg.this.needlevelhigh;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getInsistwaitsessionid()
/*      */     {
/*  887 */       MatchActivityCfg.this._xdb_verify_unsafe_();
/*  888 */       return MatchActivityCfg.this.insistwaitsessionid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getBeremovedsessionid()
/*      */     {
/*  895 */       MatchActivityCfg.this._xdb_verify_unsafe_();
/*  896 */       return MatchActivityCfg.this.beremovedsessionid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getExpandlvsessionid()
/*      */     {
/*  903 */       MatchActivityCfg.this._xdb_verify_unsafe_();
/*  904 */       return MatchActivityCfg.this.expandlvsessionid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRolebeleaderhintsessionid()
/*      */     {
/*  911 */       MatchActivityCfg.this._xdb_verify_unsafe_();
/*  912 */       return MatchActivityCfg.this.rolebeleaderhintsessionid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActivity(MatchKey _v_)
/*      */     {
/*  919 */       MatchActivityCfg.this._xdb_verify_unsafe_();
/*  920 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMatchtype(int _v_)
/*      */     {
/*  927 */       MatchActivityCfg.this._xdb_verify_unsafe_();
/*  928 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStarttime(long _v_)
/*      */     {
/*  935 */       MatchActivityCfg.this._xdb_verify_unsafe_();
/*  936 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRolelevel(int _v_)
/*      */     {
/*  943 */       MatchActivityCfg.this._xdb_verify_unsafe_();
/*  944 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLevellow(int _v_)
/*      */     {
/*  951 */       MatchActivityCfg.this._xdb_verify_unsafe_();
/*  952 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLevelhigh(int _v_)
/*      */     {
/*  959 */       MatchActivityCfg.this._xdb_verify_unsafe_();
/*  960 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNeedlevellow(int _v_)
/*      */     {
/*  967 */       MatchActivityCfg.this._xdb_verify_unsafe_();
/*  968 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNeedlevelhigh(int _v_)
/*      */     {
/*  975 */       MatchActivityCfg.this._xdb_verify_unsafe_();
/*  976 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInsistwaitsessionid(long _v_)
/*      */     {
/*  983 */       MatchActivityCfg.this._xdb_verify_unsafe_();
/*  984 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBeremovedsessionid(long _v_)
/*      */     {
/*  991 */       MatchActivityCfg.this._xdb_verify_unsafe_();
/*  992 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setExpandlvsessionid(long _v_)
/*      */     {
/*  999 */       MatchActivityCfg.this._xdb_verify_unsafe_();
/* 1000 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRolebeleaderhintsessionid(long _v_)
/*      */     {
/* 1007 */       MatchActivityCfg.this._xdb_verify_unsafe_();
/* 1008 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/* 1014 */       MatchActivityCfg.this._xdb_verify_unsafe_();
/* 1015 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/* 1021 */       MatchActivityCfg.this._xdb_verify_unsafe_();
/* 1022 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/* 1028 */       return MatchActivityCfg.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1034 */       return MatchActivityCfg.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 1040 */       MatchActivityCfg.this._xdb_verify_unsafe_();
/* 1041 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/* 1047 */       return MatchActivityCfg.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1053 */       return MatchActivityCfg.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1059 */       MatchActivityCfg.this._xdb_verify_unsafe_();
/* 1060 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/* 1066 */       return MatchActivityCfg.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1072 */       return MatchActivityCfg.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/* 1078 */       return MatchActivityCfg.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/* 1084 */       return MatchActivityCfg.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/* 1090 */       return MatchActivityCfg.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/* 1096 */       return MatchActivityCfg.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1102 */       return MatchActivityCfg.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.MatchActivityCfg
/*      */   {
/*      */     private MatchKey activity;
/*      */     
/*      */     private int matchtype;
/*      */     
/*      */     private long starttime;
/*      */     
/*      */     private int rolelevel;
/*      */     
/*      */     private int levellow;
/*      */     
/*      */     private int levelhigh;
/*      */     
/*      */     private int needlevellow;
/*      */     
/*      */     private int needlevelhigh;
/*      */     
/*      */     private long insistwaitsessionid;
/*      */     
/*      */     private long beremovedsessionid;
/*      */     
/*      */     private long expandlvsessionid;
/*      */     
/*      */     private long rolebeleaderhintsessionid;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1136 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 1141 */       this.activity = new MatchKey();
/*      */     }
/*      */     
/*      */     Data(xbean.MatchActivityCfg _o1_)
/*      */     {
/* 1146 */       if ((_o1_ instanceof MatchActivityCfg)) { assign((MatchActivityCfg)_o1_);
/* 1147 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 1148 */       } else if ((_o1_ instanceof MatchActivityCfg.Const)) assign(((MatchActivityCfg.Const)_o1_).nThis()); else {
/* 1149 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(MatchActivityCfg _o_) {
/* 1154 */       this.activity = _o_.activity;
/* 1155 */       this.matchtype = _o_.matchtype;
/* 1156 */       this.starttime = _o_.starttime;
/* 1157 */       this.rolelevel = _o_.rolelevel;
/* 1158 */       this.levellow = _o_.levellow;
/* 1159 */       this.levelhigh = _o_.levelhigh;
/* 1160 */       this.needlevellow = _o_.needlevellow;
/* 1161 */       this.needlevelhigh = _o_.needlevelhigh;
/* 1162 */       this.insistwaitsessionid = _o_.insistwaitsessionid;
/* 1163 */       this.beremovedsessionid = _o_.beremovedsessionid;
/* 1164 */       this.expandlvsessionid = _o_.expandlvsessionid;
/* 1165 */       this.rolebeleaderhintsessionid = _o_.rolebeleaderhintsessionid;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/* 1170 */       this.activity = _o_.activity;
/* 1171 */       this.matchtype = _o_.matchtype;
/* 1172 */       this.starttime = _o_.starttime;
/* 1173 */       this.rolelevel = _o_.rolelevel;
/* 1174 */       this.levellow = _o_.levellow;
/* 1175 */       this.levelhigh = _o_.levelhigh;
/* 1176 */       this.needlevellow = _o_.needlevellow;
/* 1177 */       this.needlevelhigh = _o_.needlevelhigh;
/* 1178 */       this.insistwaitsessionid = _o_.insistwaitsessionid;
/* 1179 */       this.beremovedsessionid = _o_.beremovedsessionid;
/* 1180 */       this.expandlvsessionid = _o_.expandlvsessionid;
/* 1181 */       this.rolebeleaderhintsessionid = _o_.rolebeleaderhintsessionid;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1187 */       this.activity.marshal(_os_);
/* 1188 */       _os_.marshal(this.matchtype);
/* 1189 */       _os_.marshal(this.starttime);
/* 1190 */       _os_.marshal(this.rolelevel);
/* 1191 */       _os_.marshal(this.levellow);
/* 1192 */       _os_.marshal(this.levelhigh);
/* 1193 */       _os_.marshal(this.needlevellow);
/* 1194 */       _os_.marshal(this.needlevelhigh);
/* 1195 */       _os_.marshal(this.insistwaitsessionid);
/* 1196 */       _os_.marshal(this.beremovedsessionid);
/* 1197 */       _os_.marshal(this.expandlvsessionid);
/* 1198 */       _os_.marshal(this.rolebeleaderhintsessionid);
/* 1199 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 1205 */       this.activity.unmarshal(_os_);
/* 1206 */       this.matchtype = _os_.unmarshal_int();
/* 1207 */       this.starttime = _os_.unmarshal_long();
/* 1208 */       this.rolelevel = _os_.unmarshal_int();
/* 1209 */       this.levellow = _os_.unmarshal_int();
/* 1210 */       this.levelhigh = _os_.unmarshal_int();
/* 1211 */       this.needlevellow = _os_.unmarshal_int();
/* 1212 */       this.needlevelhigh = _os_.unmarshal_int();
/* 1213 */       this.insistwaitsessionid = _os_.unmarshal_long();
/* 1214 */       this.beremovedsessionid = _os_.unmarshal_long();
/* 1215 */       this.expandlvsessionid = _os_.unmarshal_long();
/* 1216 */       this.rolebeleaderhintsessionid = _os_.unmarshal_long();
/* 1217 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1223 */       int _size_ = 0;
/* 1224 */       _size_ += CodedOutputStream.computeMessageSize(1, this.activity);
/* 1225 */       _size_ += CodedOutputStream.computeInt32Size(2, this.matchtype);
/* 1226 */       _size_ += CodedOutputStream.computeInt64Size(3, this.starttime);
/* 1227 */       _size_ += CodedOutputStream.computeInt32Size(4, this.rolelevel);
/* 1228 */       _size_ += CodedOutputStream.computeInt32Size(5, this.levellow);
/* 1229 */       _size_ += CodedOutputStream.computeInt32Size(6, this.levelhigh);
/* 1230 */       _size_ += CodedOutputStream.computeInt32Size(7, this.needlevellow);
/* 1231 */       _size_ += CodedOutputStream.computeInt32Size(8, this.needlevelhigh);
/* 1232 */       _size_ += CodedOutputStream.computeInt64Size(9, this.insistwaitsessionid);
/* 1233 */       _size_ += CodedOutputStream.computeInt64Size(10, this.beremovedsessionid);
/* 1234 */       _size_ += CodedOutputStream.computeInt64Size(11, this.expandlvsessionid);
/* 1235 */       _size_ += CodedOutputStream.computeInt64Size(12, this.rolebeleaderhintsessionid);
/* 1236 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1244 */         _output_.writeMessage(1, this.activity);
/* 1245 */         _output_.writeInt32(2, this.matchtype);
/* 1246 */         _output_.writeInt64(3, this.starttime);
/* 1247 */         _output_.writeInt32(4, this.rolelevel);
/* 1248 */         _output_.writeInt32(5, this.levellow);
/* 1249 */         _output_.writeInt32(6, this.levelhigh);
/* 1250 */         _output_.writeInt32(7, this.needlevellow);
/* 1251 */         _output_.writeInt32(8, this.needlevelhigh);
/* 1252 */         _output_.writeInt64(9, this.insistwaitsessionid);
/* 1253 */         _output_.writeInt64(10, this.beremovedsessionid);
/* 1254 */         _output_.writeInt64(11, this.expandlvsessionid);
/* 1255 */         _output_.writeInt64(12, this.rolebeleaderhintsessionid);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1259 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1261 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1269 */         boolean done = false;
/* 1270 */         while (!done)
/*      */         {
/* 1272 */           int tag = _input_.readTag();
/* 1273 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1277 */             done = true;
/* 1278 */             break;
/*      */           
/*      */ 
/*      */           case 10: 
/* 1282 */             _input_.readMessage(this.activity);
/* 1283 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1287 */             this.matchtype = _input_.readInt32();
/* 1288 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1292 */             this.starttime = _input_.readInt64();
/* 1293 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1297 */             this.rolelevel = _input_.readInt32();
/* 1298 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1302 */             this.levellow = _input_.readInt32();
/* 1303 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1307 */             this.levelhigh = _input_.readInt32();
/* 1308 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1312 */             this.needlevellow = _input_.readInt32();
/* 1313 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1317 */             this.needlevelhigh = _input_.readInt32();
/* 1318 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 1322 */             this.insistwaitsessionid = _input_.readInt64();
/* 1323 */             break;
/*      */           
/*      */ 
/*      */           case 80: 
/* 1327 */             this.beremovedsessionid = _input_.readInt64();
/* 1328 */             break;
/*      */           
/*      */ 
/*      */           case 88: 
/* 1332 */             this.expandlvsessionid = _input_.readInt64();
/* 1333 */             break;
/*      */           
/*      */ 
/*      */           case 96: 
/* 1337 */             this.rolebeleaderhintsessionid = _input_.readInt64();
/* 1338 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1342 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1344 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1353 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1357 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1359 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MatchActivityCfg copy()
/*      */     {
/* 1365 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MatchActivityCfg toData()
/*      */     {
/* 1371 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.MatchActivityCfg toBean()
/*      */     {
/* 1376 */       return new MatchActivityCfg(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MatchActivityCfg toDataIf()
/*      */     {
/* 1382 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.MatchActivityCfg toBeanIf()
/*      */     {
/* 1387 */       return new MatchActivityCfg(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1393 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 1397 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1401 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1405 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 1409 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1413 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1417 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public MatchKey getActivity()
/*      */     {
/* 1424 */       return this.activity;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMatchtype()
/*      */     {
/* 1431 */       return this.matchtype;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getStarttime()
/*      */     {
/* 1438 */       return this.starttime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRolelevel()
/*      */     {
/* 1445 */       return this.rolelevel;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLevellow()
/*      */     {
/* 1452 */       return this.levellow;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLevelhigh()
/*      */     {
/* 1459 */       return this.levelhigh;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getNeedlevellow()
/*      */     {
/* 1466 */       return this.needlevellow;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getNeedlevelhigh()
/*      */     {
/* 1473 */       return this.needlevelhigh;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getInsistwaitsessionid()
/*      */     {
/* 1480 */       return this.insistwaitsessionid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getBeremovedsessionid()
/*      */     {
/* 1487 */       return this.beremovedsessionid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getExpandlvsessionid()
/*      */     {
/* 1494 */       return this.expandlvsessionid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRolebeleaderhintsessionid()
/*      */     {
/* 1501 */       return this.rolebeleaderhintsessionid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActivity(MatchKey _v_)
/*      */     {
/* 1508 */       this.activity = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMatchtype(int _v_)
/*      */     {
/* 1515 */       this.matchtype = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStarttime(long _v_)
/*      */     {
/* 1522 */       this.starttime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRolelevel(int _v_)
/*      */     {
/* 1529 */       this.rolelevel = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLevellow(int _v_)
/*      */     {
/* 1536 */       this.levellow = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLevelhigh(int _v_)
/*      */     {
/* 1543 */       this.levelhigh = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNeedlevellow(int _v_)
/*      */     {
/* 1550 */       this.needlevellow = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNeedlevelhigh(int _v_)
/*      */     {
/* 1557 */       this.needlevelhigh = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInsistwaitsessionid(long _v_)
/*      */     {
/* 1564 */       this.insistwaitsessionid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBeremovedsessionid(long _v_)
/*      */     {
/* 1571 */       this.beremovedsessionid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setExpandlvsessionid(long _v_)
/*      */     {
/* 1578 */       this.expandlvsessionid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRolebeleaderhintsessionid(long _v_)
/*      */     {
/* 1585 */       this.rolebeleaderhintsessionid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1591 */       if (!(_o1_ instanceof Data)) return false;
/* 1592 */       Data _o_ = (Data)_o1_;
/* 1593 */       if (!this.activity.equals(_o_.activity)) return false;
/* 1594 */       if (this.matchtype != _o_.matchtype) return false;
/* 1595 */       if (this.starttime != _o_.starttime) return false;
/* 1596 */       if (this.rolelevel != _o_.rolelevel) return false;
/* 1597 */       if (this.levellow != _o_.levellow) return false;
/* 1598 */       if (this.levelhigh != _o_.levelhigh) return false;
/* 1599 */       if (this.needlevellow != _o_.needlevellow) return false;
/* 1600 */       if (this.needlevelhigh != _o_.needlevelhigh) return false;
/* 1601 */       if (this.insistwaitsessionid != _o_.insistwaitsessionid) return false;
/* 1602 */       if (this.beremovedsessionid != _o_.beremovedsessionid) return false;
/* 1603 */       if (this.expandlvsessionid != _o_.expandlvsessionid) return false;
/* 1604 */       if (this.rolebeleaderhintsessionid != _o_.rolebeleaderhintsessionid) return false;
/* 1605 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1611 */       int _h_ = 0;
/* 1612 */       _h_ += this.activity.hashCode();
/* 1613 */       _h_ += this.matchtype;
/* 1614 */       _h_ = (int)(_h_ + this.starttime);
/* 1615 */       _h_ += this.rolelevel;
/* 1616 */       _h_ += this.levellow;
/* 1617 */       _h_ += this.levelhigh;
/* 1618 */       _h_ += this.needlevellow;
/* 1619 */       _h_ += this.needlevelhigh;
/* 1620 */       _h_ = (int)(_h_ + this.insistwaitsessionid);
/* 1621 */       _h_ = (int)(_h_ + this.beremovedsessionid);
/* 1622 */       _h_ = (int)(_h_ + this.expandlvsessionid);
/* 1623 */       _h_ = (int)(_h_ + this.rolebeleaderhintsessionid);
/* 1624 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1630 */       StringBuilder _sb_ = new StringBuilder();
/* 1631 */       _sb_.append("(");
/* 1632 */       _sb_.append(this.activity);
/* 1633 */       _sb_.append(",");
/* 1634 */       _sb_.append(this.matchtype);
/* 1635 */       _sb_.append(",");
/* 1636 */       _sb_.append(this.starttime);
/* 1637 */       _sb_.append(",");
/* 1638 */       _sb_.append(this.rolelevel);
/* 1639 */       _sb_.append(",");
/* 1640 */       _sb_.append(this.levellow);
/* 1641 */       _sb_.append(",");
/* 1642 */       _sb_.append(this.levelhigh);
/* 1643 */       _sb_.append(",");
/* 1644 */       _sb_.append(this.needlevellow);
/* 1645 */       _sb_.append(",");
/* 1646 */       _sb_.append(this.needlevelhigh);
/* 1647 */       _sb_.append(",");
/* 1648 */       _sb_.append(this.insistwaitsessionid);
/* 1649 */       _sb_.append(",");
/* 1650 */       _sb_.append(this.beremovedsessionid);
/* 1651 */       _sb_.append(",");
/* 1652 */       _sb_.append(this.expandlvsessionid);
/* 1653 */       _sb_.append(",");
/* 1654 */       _sb_.append(this.rolebeleaderhintsessionid);
/* 1655 */       _sb_.append(")");
/* 1656 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MatchActivityCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */