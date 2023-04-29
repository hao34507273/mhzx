/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.util.SetX;
/*      */ 
/*      */ public final class WorldGoal extends XBean implements xbean.WorldGoal
/*      */ {
/*      */   private HashMap<Integer, xbean.Section> sections;
/*      */   private int current_section_id;
/*      */   private int extra_award_num;
/*      */   private long extra_award_num_timestamp;
/*      */   private SetX<Long> commit_roles;
/*      */   private long world_id;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.sections.clear();
/*   29 */     this.current_section_id = 0;
/*   30 */     this.extra_award_num = 0;
/*   31 */     this.extra_award_num_timestamp = 0L;
/*   32 */     this.commit_roles.clear();
/*   33 */     this.world_id = -1L;
/*      */   }
/*      */   
/*      */   WorldGoal(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*   39 */     this.sections = new HashMap();
/*   40 */     this.extra_award_num = 0;
/*   41 */     this.extra_award_num_timestamp = 0L;
/*   42 */     this.commit_roles = new SetX();
/*   43 */     this.world_id = -1L;
/*      */   }
/*      */   
/*      */   public WorldGoal()
/*      */   {
/*   48 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public WorldGoal(WorldGoal _o_)
/*      */   {
/*   53 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   WorldGoal(xbean.WorldGoal _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   58 */     super(_xp_, _vn_);
/*   59 */     if ((_o1_ instanceof WorldGoal)) { assign((WorldGoal)_o1_);
/*   60 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   61 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   62 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(WorldGoal _o_) {
/*   67 */     _o_._xdb_verify_unsafe_();
/*   68 */     this.sections = new HashMap();
/*   69 */     for (Map.Entry<Integer, xbean.Section> _e_ : _o_.sections.entrySet())
/*   70 */       this.sections.put(_e_.getKey(), new Section((xbean.Section)_e_.getValue(), this, "sections"));
/*   71 */     this.current_section_id = _o_.current_section_id;
/*   72 */     this.extra_award_num = _o_.extra_award_num;
/*   73 */     this.extra_award_num_timestamp = _o_.extra_award_num_timestamp;
/*   74 */     this.commit_roles = new SetX();
/*   75 */     this.commit_roles.addAll(_o_.commit_roles);
/*   76 */     this.world_id = _o_.world_id;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   81 */     this.sections = new HashMap();
/*   82 */     for (Map.Entry<Integer, xbean.Section> _e_ : _o_.sections.entrySet())
/*   83 */       this.sections.put(_e_.getKey(), new Section((xbean.Section)_e_.getValue(), this, "sections"));
/*   84 */     this.current_section_id = _o_.current_section_id;
/*   85 */     this.extra_award_num = _o_.extra_award_num;
/*   86 */     this.extra_award_num_timestamp = _o_.extra_award_num_timestamp;
/*   87 */     this.commit_roles = new SetX();
/*   88 */     this.commit_roles.addAll(_o_.commit_roles);
/*   89 */     this.world_id = _o_.world_id;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   95 */     _xdb_verify_unsafe_();
/*   96 */     _os_.compact_uint32(this.sections.size());
/*   97 */     for (Map.Entry<Integer, xbean.Section> _e_ : this.sections.entrySet())
/*      */     {
/*   99 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  100 */       ((xbean.Section)_e_.getValue()).marshal(_os_);
/*      */     }
/*  102 */     _os_.marshal(this.current_section_id);
/*  103 */     _os_.marshal(this.extra_award_num);
/*  104 */     _os_.marshal(this.extra_award_num_timestamp);
/*  105 */     _os_.compact_uint32(this.commit_roles.size());
/*  106 */     for (Long _v_ : this.commit_roles)
/*      */     {
/*  108 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  110 */     _os_.marshal(this.world_id);
/*  111 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  117 */     _xdb_verify_unsafe_();
/*      */     
/*  119 */     int size = _os_.uncompact_uint32();
/*  120 */     if (size >= 12)
/*      */     {
/*  122 */       this.sections = new HashMap(size * 2);
/*      */     }
/*  124 */     for (; size > 0; size--)
/*      */     {
/*  126 */       int _k_ = 0;
/*  127 */       _k_ = _os_.unmarshal_int();
/*  128 */       xbean.Section _v_ = new Section(0, this, "sections");
/*  129 */       _v_.unmarshal(_os_);
/*  130 */       this.sections.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  133 */     this.current_section_id = _os_.unmarshal_int();
/*  134 */     this.extra_award_num = _os_.unmarshal_int();
/*  135 */     this.extra_award_num_timestamp = _os_.unmarshal_long();
/*  136 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  138 */       long _v_ = 0L;
/*  139 */       _v_ = _os_.unmarshal_long();
/*  140 */       this.commit_roles.add(Long.valueOf(_v_));
/*      */     }
/*  142 */     this.world_id = _os_.unmarshal_long();
/*  143 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  149 */     _xdb_verify_unsafe_();
/*  150 */     int _size_ = 0;
/*  151 */     for (Map.Entry<Integer, xbean.Section> _e_ : this.sections.entrySet())
/*      */     {
/*  153 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/*  154 */       _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*      */     }
/*  156 */     _size_ += CodedOutputStream.computeInt32Size(2, this.current_section_id);
/*  157 */     _size_ += CodedOutputStream.computeInt32Size(3, this.extra_award_num);
/*  158 */     _size_ += CodedOutputStream.computeInt64Size(4, this.extra_award_num_timestamp);
/*  159 */     for (Long _v_ : this.commit_roles)
/*      */     {
/*  161 */       _size_ += CodedOutputStream.computeInt64Size(5, _v_.longValue());
/*      */     }
/*  163 */     _size_ += CodedOutputStream.computeInt64Size(6, this.world_id);
/*  164 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  170 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  173 */       for (Map.Entry<Integer, xbean.Section> _e_ : this.sections.entrySet())
/*      */       {
/*  175 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/*  176 */         _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*      */       }
/*  178 */       _output_.writeInt32(2, this.current_section_id);
/*  179 */       _output_.writeInt32(3, this.extra_award_num);
/*  180 */       _output_.writeInt64(4, this.extra_award_num_timestamp);
/*  181 */       for (Long _v_ : this.commit_roles)
/*      */       {
/*  183 */         _output_.writeInt64(5, _v_.longValue());
/*      */       }
/*  185 */       _output_.writeInt64(6, this.world_id);
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  189 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  191 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  197 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  200 */       boolean done = false;
/*  201 */       while (!done)
/*      */       {
/*  203 */         int tag = _input_.readTag();
/*  204 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  208 */           done = true;
/*  209 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  213 */           int _k_ = 0;
/*  214 */           _k_ = _input_.readInt32();
/*  215 */           int readTag = _input_.readTag();
/*  216 */           if (10 != readTag)
/*      */           {
/*  218 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  220 */           xbean.Section _v_ = new Section(0, this, "sections");
/*  221 */           _input_.readMessage(_v_);
/*  222 */           this.sections.put(Integer.valueOf(_k_), _v_);
/*  223 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  227 */           this.current_section_id = _input_.readInt32();
/*  228 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  232 */           this.extra_award_num = _input_.readInt32();
/*  233 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  237 */           this.extra_award_num_timestamp = _input_.readInt64();
/*  238 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  242 */           long _v_ = 0L;
/*  243 */           _v_ = _input_.readInt64();
/*  244 */           this.commit_roles.add(Long.valueOf(_v_));
/*  245 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  249 */           this.world_id = _input_.readInt64();
/*  250 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  254 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  256 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  265 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  269 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  271 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.WorldGoal copy()
/*      */   {
/*  277 */     _xdb_verify_unsafe_();
/*  278 */     return new WorldGoal(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.WorldGoal toData()
/*      */   {
/*  284 */     _xdb_verify_unsafe_();
/*  285 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.WorldGoal toBean()
/*      */   {
/*  290 */     _xdb_verify_unsafe_();
/*  291 */     return new WorldGoal(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.WorldGoal toDataIf()
/*      */   {
/*  297 */     _xdb_verify_unsafe_();
/*  298 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.WorldGoal toBeanIf()
/*      */   {
/*  303 */     _xdb_verify_unsafe_();
/*  304 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  310 */     _xdb_verify_unsafe_();
/*  311 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.Section> getSections()
/*      */   {
/*  318 */     _xdb_verify_unsafe_();
/*  319 */     return xdb.Logs.logMap(new LogKey(this, "sections"), this.sections);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.Section> getSectionsAsData()
/*      */   {
/*  326 */     _xdb_verify_unsafe_();
/*      */     
/*  328 */     WorldGoal _o_ = this;
/*  329 */     Map<Integer, xbean.Section> sections = new HashMap();
/*  330 */     for (Map.Entry<Integer, xbean.Section> _e_ : _o_.sections.entrySet())
/*  331 */       sections.put(_e_.getKey(), new Section.Data((xbean.Section)_e_.getValue()));
/*  332 */     return sections;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCurrent_section_id()
/*      */   {
/*  339 */     _xdb_verify_unsafe_();
/*  340 */     return this.current_section_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getExtra_award_num()
/*      */   {
/*  347 */     _xdb_verify_unsafe_();
/*  348 */     return this.extra_award_num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getExtra_award_num_timestamp()
/*      */   {
/*  355 */     _xdb_verify_unsafe_();
/*  356 */     return this.extra_award_num_timestamp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Long> getCommit_roles()
/*      */   {
/*  363 */     _xdb_verify_unsafe_();
/*  364 */     return xdb.Logs.logSet(new LogKey(this, "commit_roles"), this.commit_roles);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Long> getCommit_rolesAsData()
/*      */   {
/*  370 */     _xdb_verify_unsafe_();
/*      */     
/*  372 */     WorldGoal _o_ = this;
/*  373 */     Set<Long> commit_roles = new SetX();
/*  374 */     commit_roles.addAll(_o_.commit_roles);
/*  375 */     return commit_roles;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getWorld_id()
/*      */   {
/*  382 */     _xdb_verify_unsafe_();
/*  383 */     return this.world_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCurrent_section_id(int _v_)
/*      */   {
/*  390 */     _xdb_verify_unsafe_();
/*  391 */     xdb.Logs.logIf(new LogKey(this, "current_section_id")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  395 */         new xdb.logs.LogInt(this, WorldGoal.this.current_section_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  399 */             WorldGoal.this.current_section_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  403 */     });
/*  404 */     this.current_section_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setExtra_award_num(int _v_)
/*      */   {
/*  411 */     _xdb_verify_unsafe_();
/*  412 */     xdb.Logs.logIf(new LogKey(this, "extra_award_num")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  416 */         new xdb.logs.LogInt(this, WorldGoal.this.extra_award_num)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  420 */             WorldGoal.this.extra_award_num = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  424 */     });
/*  425 */     this.extra_award_num = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setExtra_award_num_timestamp(long _v_)
/*      */   {
/*  432 */     _xdb_verify_unsafe_();
/*  433 */     xdb.Logs.logIf(new LogKey(this, "extra_award_num_timestamp")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  437 */         new xdb.logs.LogLong(this, WorldGoal.this.extra_award_num_timestamp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  441 */             WorldGoal.this.extra_award_num_timestamp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  445 */     });
/*  446 */     this.extra_award_num_timestamp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setWorld_id(long _v_)
/*      */   {
/*  453 */     _xdb_verify_unsafe_();
/*  454 */     xdb.Logs.logIf(new LogKey(this, "world_id")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  458 */         new xdb.logs.LogLong(this, WorldGoal.this.world_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  462 */             WorldGoal.this.world_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  466 */     });
/*  467 */     this.world_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  473 */     _xdb_verify_unsafe_();
/*  474 */     WorldGoal _o_ = null;
/*  475 */     if ((_o1_ instanceof WorldGoal)) { _o_ = (WorldGoal)_o1_;
/*  476 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  477 */       return false;
/*  478 */     if (!this.sections.equals(_o_.sections)) return false;
/*  479 */     if (this.current_section_id != _o_.current_section_id) return false;
/*  480 */     if (this.extra_award_num != _o_.extra_award_num) return false;
/*  481 */     if (this.extra_award_num_timestamp != _o_.extra_award_num_timestamp) return false;
/*  482 */     if (!this.commit_roles.equals(_o_.commit_roles)) return false;
/*  483 */     if (this.world_id != _o_.world_id) return false;
/*  484 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  490 */     _xdb_verify_unsafe_();
/*  491 */     int _h_ = 0;
/*  492 */     _h_ += this.sections.hashCode();
/*  493 */     _h_ += this.current_section_id;
/*  494 */     _h_ += this.extra_award_num;
/*  495 */     _h_ = (int)(_h_ + this.extra_award_num_timestamp);
/*  496 */     _h_ += this.commit_roles.hashCode();
/*  497 */     _h_ = (int)(_h_ + this.world_id);
/*  498 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  504 */     _xdb_verify_unsafe_();
/*  505 */     StringBuilder _sb_ = new StringBuilder();
/*  506 */     _sb_.append("(");
/*  507 */     _sb_.append(this.sections);
/*  508 */     _sb_.append(",");
/*  509 */     _sb_.append(this.current_section_id);
/*  510 */     _sb_.append(",");
/*  511 */     _sb_.append(this.extra_award_num);
/*  512 */     _sb_.append(",");
/*  513 */     _sb_.append(this.extra_award_num_timestamp);
/*  514 */     _sb_.append(",");
/*  515 */     _sb_.append(this.commit_roles);
/*  516 */     _sb_.append(",");
/*  517 */     _sb_.append(this.world_id);
/*  518 */     _sb_.append(")");
/*  519 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  525 */     ListenableBean lb = new ListenableBean();
/*  526 */     lb.add(new xdb.logs.ListenableMap().setVarName("sections"));
/*  527 */     lb.add(new xdb.logs.ListenableChanged().setVarName("current_section_id"));
/*  528 */     lb.add(new xdb.logs.ListenableChanged().setVarName("extra_award_num"));
/*  529 */     lb.add(new xdb.logs.ListenableChanged().setVarName("extra_award_num_timestamp"));
/*  530 */     lb.add(new xdb.logs.ListenableSet().setVarName("commit_roles"));
/*  531 */     lb.add(new xdb.logs.ListenableChanged().setVarName("world_id"));
/*  532 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.WorldGoal {
/*      */     private Const() {}
/*      */     
/*      */     WorldGoal nThis() {
/*  539 */       return WorldGoal.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  545 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.WorldGoal copy()
/*      */     {
/*  551 */       return WorldGoal.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.WorldGoal toData()
/*      */     {
/*  557 */       return WorldGoal.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.WorldGoal toBean()
/*      */     {
/*  562 */       return WorldGoal.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.WorldGoal toDataIf()
/*      */     {
/*  568 */       return WorldGoal.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.WorldGoal toBeanIf()
/*      */     {
/*  573 */       return WorldGoal.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.Section> getSections()
/*      */     {
/*  580 */       WorldGoal.this._xdb_verify_unsafe_();
/*  581 */       return xdb.Consts.constMap(WorldGoal.this.sections);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.Section> getSectionsAsData()
/*      */     {
/*  588 */       WorldGoal.this._xdb_verify_unsafe_();
/*      */       
/*  590 */       WorldGoal _o_ = WorldGoal.this;
/*  591 */       Map<Integer, xbean.Section> sections = new HashMap();
/*  592 */       for (Map.Entry<Integer, xbean.Section> _e_ : _o_.sections.entrySet())
/*  593 */         sections.put(_e_.getKey(), new Section.Data((xbean.Section)_e_.getValue()));
/*  594 */       return sections;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrent_section_id()
/*      */     {
/*  601 */       WorldGoal.this._xdb_verify_unsafe_();
/*  602 */       return WorldGoal.this.current_section_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getExtra_award_num()
/*      */     {
/*  609 */       WorldGoal.this._xdb_verify_unsafe_();
/*  610 */       return WorldGoal.this.extra_award_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getExtra_award_num_timestamp()
/*      */     {
/*  617 */       WorldGoal.this._xdb_verify_unsafe_();
/*  618 */       return WorldGoal.this.extra_award_num_timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getCommit_roles()
/*      */     {
/*  625 */       WorldGoal.this._xdb_verify_unsafe_();
/*  626 */       return xdb.Consts.constSet(WorldGoal.this.commit_roles);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Long> getCommit_rolesAsData()
/*      */     {
/*  632 */       WorldGoal.this._xdb_verify_unsafe_();
/*      */       
/*  634 */       WorldGoal _o_ = WorldGoal.this;
/*  635 */       Set<Long> commit_roles = new SetX();
/*  636 */       commit_roles.addAll(_o_.commit_roles);
/*  637 */       return commit_roles;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getWorld_id()
/*      */     {
/*  644 */       WorldGoal.this._xdb_verify_unsafe_();
/*  645 */       return WorldGoal.this.world_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_section_id(int _v_)
/*      */     {
/*  652 */       WorldGoal.this._xdb_verify_unsafe_();
/*  653 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setExtra_award_num(int _v_)
/*      */     {
/*  660 */       WorldGoal.this._xdb_verify_unsafe_();
/*  661 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setExtra_award_num_timestamp(long _v_)
/*      */     {
/*  668 */       WorldGoal.this._xdb_verify_unsafe_();
/*  669 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWorld_id(long _v_)
/*      */     {
/*  676 */       WorldGoal.this._xdb_verify_unsafe_();
/*  677 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  683 */       WorldGoal.this._xdb_verify_unsafe_();
/*  684 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  690 */       WorldGoal.this._xdb_verify_unsafe_();
/*  691 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  697 */       return WorldGoal.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  703 */       return WorldGoal.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  709 */       WorldGoal.this._xdb_verify_unsafe_();
/*  710 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  716 */       return WorldGoal.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  722 */       return WorldGoal.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  728 */       WorldGoal.this._xdb_verify_unsafe_();
/*  729 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  735 */       return WorldGoal.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  741 */       return WorldGoal.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  747 */       return WorldGoal.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  753 */       return WorldGoal.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  759 */       return WorldGoal.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  765 */       return WorldGoal.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  771 */       return WorldGoal.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.WorldGoal
/*      */   {
/*      */     private HashMap<Integer, xbean.Section> sections;
/*      */     
/*      */     private int current_section_id;
/*      */     
/*      */     private int extra_award_num;
/*      */     
/*      */     private long extra_award_num_timestamp;
/*      */     
/*      */     private HashSet<Long> commit_roles;
/*      */     
/*      */     private long world_id;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  793 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  798 */       this.sections = new HashMap();
/*  799 */       this.extra_award_num = 0;
/*  800 */       this.extra_award_num_timestamp = 0L;
/*  801 */       this.commit_roles = new HashSet();
/*  802 */       this.world_id = -1L;
/*      */     }
/*      */     
/*      */     Data(xbean.WorldGoal _o1_)
/*      */     {
/*  807 */       if ((_o1_ instanceof WorldGoal)) { assign((WorldGoal)_o1_);
/*  808 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  809 */       } else if ((_o1_ instanceof WorldGoal.Const)) assign(((WorldGoal.Const)_o1_).nThis()); else {
/*  810 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(WorldGoal _o_) {
/*  815 */       this.sections = new HashMap();
/*  816 */       for (Map.Entry<Integer, xbean.Section> _e_ : _o_.sections.entrySet())
/*  817 */         this.sections.put(_e_.getKey(), new Section.Data((xbean.Section)_e_.getValue()));
/*  818 */       this.current_section_id = _o_.current_section_id;
/*  819 */       this.extra_award_num = _o_.extra_award_num;
/*  820 */       this.extra_award_num_timestamp = _o_.extra_award_num_timestamp;
/*  821 */       this.commit_roles = new HashSet();
/*  822 */       this.commit_roles.addAll(_o_.commit_roles);
/*  823 */       this.world_id = _o_.world_id;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  828 */       this.sections = new HashMap();
/*  829 */       for (Map.Entry<Integer, xbean.Section> _e_ : _o_.sections.entrySet())
/*  830 */         this.sections.put(_e_.getKey(), new Section.Data((xbean.Section)_e_.getValue()));
/*  831 */       this.current_section_id = _o_.current_section_id;
/*  832 */       this.extra_award_num = _o_.extra_award_num;
/*  833 */       this.extra_award_num_timestamp = _o_.extra_award_num_timestamp;
/*  834 */       this.commit_roles = new HashSet();
/*  835 */       this.commit_roles.addAll(_o_.commit_roles);
/*  836 */       this.world_id = _o_.world_id;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  842 */       _os_.compact_uint32(this.sections.size());
/*  843 */       for (Map.Entry<Integer, xbean.Section> _e_ : this.sections.entrySet())
/*      */       {
/*  845 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  846 */         ((xbean.Section)_e_.getValue()).marshal(_os_);
/*      */       }
/*  848 */       _os_.marshal(this.current_section_id);
/*  849 */       _os_.marshal(this.extra_award_num);
/*  850 */       _os_.marshal(this.extra_award_num_timestamp);
/*  851 */       _os_.compact_uint32(this.commit_roles.size());
/*  852 */       for (Long _v_ : this.commit_roles)
/*      */       {
/*  854 */         _os_.marshal(_v_.longValue());
/*      */       }
/*  856 */       _os_.marshal(this.world_id);
/*  857 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  864 */       int size = _os_.uncompact_uint32();
/*  865 */       if (size >= 12)
/*      */       {
/*  867 */         this.sections = new HashMap(size * 2);
/*      */       }
/*  869 */       for (; size > 0; size--)
/*      */       {
/*  871 */         int _k_ = 0;
/*  872 */         _k_ = _os_.unmarshal_int();
/*  873 */         xbean.Section _v_ = xbean.Pod.newSectionData();
/*  874 */         _v_.unmarshal(_os_);
/*  875 */         this.sections.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*  878 */       this.current_section_id = _os_.unmarshal_int();
/*  879 */       this.extra_award_num = _os_.unmarshal_int();
/*  880 */       this.extra_award_num_timestamp = _os_.unmarshal_long();
/*  881 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  883 */         long _v_ = 0L;
/*  884 */         _v_ = _os_.unmarshal_long();
/*  885 */         this.commit_roles.add(Long.valueOf(_v_));
/*      */       }
/*  887 */       this.world_id = _os_.unmarshal_long();
/*  888 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  894 */       int _size_ = 0;
/*  895 */       for (Map.Entry<Integer, xbean.Section> _e_ : this.sections.entrySet())
/*      */       {
/*  897 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/*  898 */         _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*      */       }
/*  900 */       _size_ += CodedOutputStream.computeInt32Size(2, this.current_section_id);
/*  901 */       _size_ += CodedOutputStream.computeInt32Size(3, this.extra_award_num);
/*  902 */       _size_ += CodedOutputStream.computeInt64Size(4, this.extra_award_num_timestamp);
/*  903 */       for (Long _v_ : this.commit_roles)
/*      */       {
/*  905 */         _size_ += CodedOutputStream.computeInt64Size(5, _v_.longValue());
/*      */       }
/*  907 */       _size_ += CodedOutputStream.computeInt64Size(6, this.world_id);
/*  908 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  916 */         for (Map.Entry<Integer, xbean.Section> _e_ : this.sections.entrySet())
/*      */         {
/*  918 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/*  919 */           _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*      */         }
/*  921 */         _output_.writeInt32(2, this.current_section_id);
/*  922 */         _output_.writeInt32(3, this.extra_award_num);
/*  923 */         _output_.writeInt64(4, this.extra_award_num_timestamp);
/*  924 */         for (Long _v_ : this.commit_roles)
/*      */         {
/*  926 */           _output_.writeInt64(5, _v_.longValue());
/*      */         }
/*  928 */         _output_.writeInt64(6, this.world_id);
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/*  932 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  934 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  942 */         boolean done = false;
/*  943 */         while (!done)
/*      */         {
/*  945 */           int tag = _input_.readTag();
/*  946 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  950 */             done = true;
/*  951 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  955 */             int _k_ = 0;
/*  956 */             _k_ = _input_.readInt32();
/*  957 */             int readTag = _input_.readTag();
/*  958 */             if (10 != readTag)
/*      */             {
/*  960 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  962 */             xbean.Section _v_ = xbean.Pod.newSectionData();
/*  963 */             _input_.readMessage(_v_);
/*  964 */             this.sections.put(Integer.valueOf(_k_), _v_);
/*  965 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  969 */             this.current_section_id = _input_.readInt32();
/*  970 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  974 */             this.extra_award_num = _input_.readInt32();
/*  975 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  979 */             this.extra_award_num_timestamp = _input_.readInt64();
/*  980 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  984 */             long _v_ = 0L;
/*  985 */             _v_ = _input_.readInt64();
/*  986 */             this.commit_roles.add(Long.valueOf(_v_));
/*  987 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  991 */             this.world_id = _input_.readInt64();
/*  992 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  996 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  998 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1007 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/* 1011 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1013 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.WorldGoal copy()
/*      */     {
/* 1019 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.WorldGoal toData()
/*      */     {
/* 1025 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.WorldGoal toBean()
/*      */     {
/* 1030 */       return new WorldGoal(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.WorldGoal toDataIf()
/*      */     {
/* 1036 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.WorldGoal toBeanIf()
/*      */     {
/* 1041 */       return new WorldGoal(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1047 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1051 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1055 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1059 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1063 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1067 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1071 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.Section> getSections()
/*      */     {
/* 1078 */       return this.sections;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.Section> getSectionsAsData()
/*      */     {
/* 1085 */       return this.sections;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrent_section_id()
/*      */     {
/* 1092 */       return this.current_section_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getExtra_award_num()
/*      */     {
/* 1099 */       return this.extra_award_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getExtra_award_num_timestamp()
/*      */     {
/* 1106 */       return this.extra_award_num_timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getCommit_roles()
/*      */     {
/* 1113 */       return this.commit_roles;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getCommit_rolesAsData()
/*      */     {
/* 1120 */       return this.commit_roles;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getWorld_id()
/*      */     {
/* 1127 */       return this.world_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_section_id(int _v_)
/*      */     {
/* 1134 */       this.current_section_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setExtra_award_num(int _v_)
/*      */     {
/* 1141 */       this.extra_award_num = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setExtra_award_num_timestamp(long _v_)
/*      */     {
/* 1148 */       this.extra_award_num_timestamp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWorld_id(long _v_)
/*      */     {
/* 1155 */       this.world_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1161 */       if (!(_o1_ instanceof Data)) return false;
/* 1162 */       Data _o_ = (Data)_o1_;
/* 1163 */       if (!this.sections.equals(_o_.sections)) return false;
/* 1164 */       if (this.current_section_id != _o_.current_section_id) return false;
/* 1165 */       if (this.extra_award_num != _o_.extra_award_num) return false;
/* 1166 */       if (this.extra_award_num_timestamp != _o_.extra_award_num_timestamp) return false;
/* 1167 */       if (!this.commit_roles.equals(_o_.commit_roles)) return false;
/* 1168 */       if (this.world_id != _o_.world_id) return false;
/* 1169 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1175 */       int _h_ = 0;
/* 1176 */       _h_ += this.sections.hashCode();
/* 1177 */       _h_ += this.current_section_id;
/* 1178 */       _h_ += this.extra_award_num;
/* 1179 */       _h_ = (int)(_h_ + this.extra_award_num_timestamp);
/* 1180 */       _h_ += this.commit_roles.hashCode();
/* 1181 */       _h_ = (int)(_h_ + this.world_id);
/* 1182 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1188 */       StringBuilder _sb_ = new StringBuilder();
/* 1189 */       _sb_.append("(");
/* 1190 */       _sb_.append(this.sections);
/* 1191 */       _sb_.append(",");
/* 1192 */       _sb_.append(this.current_section_id);
/* 1193 */       _sb_.append(",");
/* 1194 */       _sb_.append(this.extra_award_num);
/* 1195 */       _sb_.append(",");
/* 1196 */       _sb_.append(this.extra_award_num_timestamp);
/* 1197 */       _sb_.append(",");
/* 1198 */       _sb_.append(this.commit_roles);
/* 1199 */       _sb_.append(",");
/* 1200 */       _sb_.append(this.world_id);
/* 1201 */       _sb_.append(")");
/* 1202 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\WorldGoal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */