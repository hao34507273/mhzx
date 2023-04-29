/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.util.SetX;
/*      */ 
/*      */ public final class PlantTreeInfo extends XBean implements xbean.PlantTreeInfo
/*      */ {
/*      */   private HashMap<Integer, Integer> sections;
/*      */   private int current_section_id;
/*      */   private int special_state_index;
/*      */   private LinkedList<xbean.PlantTreeLog> logs;
/*      */   private long special_state_refresh_sessionid;
/*      */   private SetX<Integer> award_section_ids;
/*      */   private boolean has_get_activity_complete_award;
/*      */   private int add_point_times;
/*      */   private int remove_special_state_award_times;
/*      */   private int online_reward_point;
/*      */   private long online_reward_point_timestamp;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   38 */     this.sections.clear();
/*   39 */     this.current_section_id = 1;
/*   40 */     this.special_state_index = 0;
/*   41 */     this.logs.clear();
/*   42 */     this.special_state_refresh_sessionid = -1L;
/*   43 */     this.award_section_ids.clear();
/*   44 */     this.has_get_activity_complete_award = false;
/*   45 */     this.add_point_times = 0;
/*   46 */     this.remove_special_state_award_times = 0;
/*   47 */     this.online_reward_point = 0;
/*   48 */     this.online_reward_point_timestamp = -1L;
/*      */   }
/*      */   
/*      */   PlantTreeInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   53 */     super(_xp_, _vn_);
/*   54 */     this.sections = new HashMap();
/*   55 */     this.current_section_id = 1;
/*   56 */     this.special_state_index = 0;
/*   57 */     this.logs = new LinkedList();
/*   58 */     this.special_state_refresh_sessionid = -1L;
/*   59 */     this.award_section_ids = new SetX();
/*   60 */     this.has_get_activity_complete_award = false;
/*   61 */     this.add_point_times = 0;
/*   62 */     this.remove_special_state_award_times = 0;
/*   63 */     this.online_reward_point = 0;
/*   64 */     this.online_reward_point_timestamp = -1L;
/*      */   }
/*      */   
/*      */   public PlantTreeInfo()
/*      */   {
/*   69 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public PlantTreeInfo(PlantTreeInfo _o_)
/*      */   {
/*   74 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   PlantTreeInfo(xbean.PlantTreeInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   79 */     super(_xp_, _vn_);
/*   80 */     if ((_o1_ instanceof PlantTreeInfo)) { assign((PlantTreeInfo)_o1_);
/*   81 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   82 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   83 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(PlantTreeInfo _o_) {
/*   88 */     _o_._xdb_verify_unsafe_();
/*   89 */     this.sections = new HashMap();
/*   90 */     for (Map.Entry<Integer, Integer> _e_ : _o_.sections.entrySet())
/*   91 */       this.sections.put(_e_.getKey(), _e_.getValue());
/*   92 */     this.current_section_id = _o_.current_section_id;
/*   93 */     this.special_state_index = _o_.special_state_index;
/*   94 */     this.logs = new LinkedList();
/*   95 */     for (xbean.PlantTreeLog _v_ : _o_.logs)
/*   96 */       this.logs.add(new PlantTreeLog(_v_, this, "logs"));
/*   97 */     this.special_state_refresh_sessionid = _o_.special_state_refresh_sessionid;
/*   98 */     this.award_section_ids = new SetX();
/*   99 */     this.award_section_ids.addAll(_o_.award_section_ids);
/*  100 */     this.has_get_activity_complete_award = _o_.has_get_activity_complete_award;
/*  101 */     this.add_point_times = _o_.add_point_times;
/*  102 */     this.remove_special_state_award_times = _o_.remove_special_state_award_times;
/*  103 */     this.online_reward_point = _o_.online_reward_point;
/*  104 */     this.online_reward_point_timestamp = _o_.online_reward_point_timestamp;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*  109 */     this.sections = new HashMap();
/*  110 */     for (Map.Entry<Integer, Integer> _e_ : _o_.sections.entrySet())
/*  111 */       this.sections.put(_e_.getKey(), _e_.getValue());
/*  112 */     this.current_section_id = _o_.current_section_id;
/*  113 */     this.special_state_index = _o_.special_state_index;
/*  114 */     this.logs = new LinkedList();
/*  115 */     for (xbean.PlantTreeLog _v_ : _o_.logs)
/*  116 */       this.logs.add(new PlantTreeLog(_v_, this, "logs"));
/*  117 */     this.special_state_refresh_sessionid = _o_.special_state_refresh_sessionid;
/*  118 */     this.award_section_ids = new SetX();
/*  119 */     this.award_section_ids.addAll(_o_.award_section_ids);
/*  120 */     this.has_get_activity_complete_award = _o_.has_get_activity_complete_award;
/*  121 */     this.add_point_times = _o_.add_point_times;
/*  122 */     this.remove_special_state_award_times = _o_.remove_special_state_award_times;
/*  123 */     this.online_reward_point = _o_.online_reward_point;
/*  124 */     this.online_reward_point_timestamp = _o_.online_reward_point_timestamp;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  130 */     _xdb_verify_unsafe_();
/*  131 */     _os_.compact_uint32(this.sections.size());
/*  132 */     for (Map.Entry<Integer, Integer> _e_ : this.sections.entrySet())
/*      */     {
/*  134 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  135 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  137 */     _os_.marshal(this.current_section_id);
/*  138 */     _os_.marshal(this.special_state_index);
/*  139 */     _os_.compact_uint32(this.logs.size());
/*  140 */     for (xbean.PlantTreeLog _v_ : this.logs)
/*      */     {
/*  142 */       _v_.marshal(_os_);
/*      */     }
/*  144 */     _os_.marshal(this.special_state_refresh_sessionid);
/*  145 */     _os_.compact_uint32(this.award_section_ids.size());
/*  146 */     for (Integer _v_ : this.award_section_ids)
/*      */     {
/*  148 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  150 */     _os_.marshal(this.has_get_activity_complete_award);
/*  151 */     _os_.marshal(this.add_point_times);
/*  152 */     _os_.marshal(this.remove_special_state_award_times);
/*  153 */     _os_.marshal(this.online_reward_point);
/*  154 */     _os_.marshal(this.online_reward_point_timestamp);
/*  155 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  161 */     _xdb_verify_unsafe_();
/*      */     
/*  163 */     int size = _os_.uncompact_uint32();
/*  164 */     if (size >= 12)
/*      */     {
/*  166 */       this.sections = new HashMap(size * 2);
/*      */     }
/*  168 */     for (; size > 0; size--)
/*      */     {
/*  170 */       int _k_ = 0;
/*  171 */       _k_ = _os_.unmarshal_int();
/*  172 */       int _v_ = 0;
/*  173 */       _v_ = _os_.unmarshal_int();
/*  174 */       this.sections.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  177 */     this.current_section_id = _os_.unmarshal_int();
/*  178 */     this.special_state_index = _os_.unmarshal_int();
/*  179 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  181 */       xbean.PlantTreeLog _v_ = new PlantTreeLog(0, this, "logs");
/*  182 */       _v_.unmarshal(_os_);
/*  183 */       this.logs.add(_v_);
/*      */     }
/*  185 */     this.special_state_refresh_sessionid = _os_.unmarshal_long();
/*  186 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  188 */       int _v_ = 0;
/*  189 */       _v_ = _os_.unmarshal_int();
/*  190 */       this.award_section_ids.add(Integer.valueOf(_v_));
/*      */     }
/*  192 */     this.has_get_activity_complete_award = _os_.unmarshal_boolean();
/*  193 */     this.add_point_times = _os_.unmarshal_int();
/*  194 */     this.remove_special_state_award_times = _os_.unmarshal_int();
/*  195 */     this.online_reward_point = _os_.unmarshal_int();
/*  196 */     this.online_reward_point_timestamp = _os_.unmarshal_long();
/*  197 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  203 */     _xdb_verify_unsafe_();
/*  204 */     int _size_ = 0;
/*  205 */     for (Map.Entry<Integer, Integer> _e_ : this.sections.entrySet())
/*      */     {
/*  207 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/*  208 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  210 */     _size_ += CodedOutputStream.computeInt32Size(2, this.current_section_id);
/*  211 */     _size_ += CodedOutputStream.computeInt32Size(3, this.special_state_index);
/*  212 */     for (xbean.PlantTreeLog _v_ : this.logs)
/*      */     {
/*  214 */       _size_ += CodedOutputStream.computeMessageSize(4, _v_);
/*      */     }
/*  216 */     _size_ += CodedOutputStream.computeInt64Size(5, this.special_state_refresh_sessionid);
/*  217 */     for (Integer _v_ : this.award_section_ids)
/*      */     {
/*  219 */       _size_ += CodedOutputStream.computeInt32Size(6, _v_.intValue());
/*      */     }
/*  221 */     _size_ += CodedOutputStream.computeBoolSize(7, this.has_get_activity_complete_award);
/*  222 */     _size_ += CodedOutputStream.computeInt32Size(8, this.add_point_times);
/*  223 */     _size_ += CodedOutputStream.computeInt32Size(9, this.remove_special_state_award_times);
/*  224 */     _size_ += CodedOutputStream.computeInt32Size(10, this.online_reward_point);
/*  225 */     _size_ += CodedOutputStream.computeInt64Size(11, this.online_reward_point_timestamp);
/*  226 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  232 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  235 */       for (Map.Entry<Integer, Integer> _e_ : this.sections.entrySet())
/*      */       {
/*  237 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/*  238 */         _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  240 */       _output_.writeInt32(2, this.current_section_id);
/*  241 */       _output_.writeInt32(3, this.special_state_index);
/*  242 */       for (xbean.PlantTreeLog _v_ : this.logs)
/*      */       {
/*  244 */         _output_.writeMessage(4, _v_);
/*      */       }
/*  246 */       _output_.writeInt64(5, this.special_state_refresh_sessionid);
/*  247 */       for (Integer _v_ : this.award_section_ids)
/*      */       {
/*  249 */         _output_.writeInt32(6, _v_.intValue());
/*      */       }
/*  251 */       _output_.writeBool(7, this.has_get_activity_complete_award);
/*  252 */       _output_.writeInt32(8, this.add_point_times);
/*  253 */       _output_.writeInt32(9, this.remove_special_state_award_times);
/*  254 */       _output_.writeInt32(10, this.online_reward_point);
/*  255 */       _output_.writeInt64(11, this.online_reward_point_timestamp);
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  259 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  261 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  267 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  270 */       boolean done = false;
/*  271 */       while (!done)
/*      */       {
/*  273 */         int tag = _input_.readTag();
/*  274 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  278 */           done = true;
/*  279 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  283 */           int _k_ = 0;
/*  284 */           _k_ = _input_.readInt32();
/*  285 */           int readTag = _input_.readTag();
/*  286 */           if (8 != readTag)
/*      */           {
/*  288 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  290 */           int _v_ = 0;
/*  291 */           _v_ = _input_.readInt32();
/*  292 */           this.sections.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  293 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  297 */           this.current_section_id = _input_.readInt32();
/*  298 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  302 */           this.special_state_index = _input_.readInt32();
/*  303 */           break;
/*      */         
/*      */ 
/*      */         case 34: 
/*  307 */           xbean.PlantTreeLog _v_ = new PlantTreeLog(0, this, "logs");
/*  308 */           _input_.readMessage(_v_);
/*  309 */           this.logs.add(_v_);
/*  310 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  314 */           this.special_state_refresh_sessionid = _input_.readInt64();
/*  315 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  319 */           int _v_ = 0;
/*  320 */           _v_ = _input_.readInt32();
/*  321 */           this.award_section_ids.add(Integer.valueOf(_v_));
/*  322 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  326 */           this.has_get_activity_complete_award = _input_.readBool();
/*  327 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  331 */           this.add_point_times = _input_.readInt32();
/*  332 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  336 */           this.remove_special_state_award_times = _input_.readInt32();
/*  337 */           break;
/*      */         
/*      */ 
/*      */         case 80: 
/*  341 */           this.online_reward_point = _input_.readInt32();
/*  342 */           break;
/*      */         
/*      */ 
/*      */         case 88: 
/*  346 */           this.online_reward_point_timestamp = _input_.readInt64();
/*  347 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  351 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  353 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  362 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  366 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  368 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.PlantTreeInfo copy()
/*      */   {
/*  374 */     _xdb_verify_unsafe_();
/*  375 */     return new PlantTreeInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.PlantTreeInfo toData()
/*      */   {
/*  381 */     _xdb_verify_unsafe_();
/*  382 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.PlantTreeInfo toBean()
/*      */   {
/*  387 */     _xdb_verify_unsafe_();
/*  388 */     return new PlantTreeInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.PlantTreeInfo toDataIf()
/*      */   {
/*  394 */     _xdb_verify_unsafe_();
/*  395 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.PlantTreeInfo toBeanIf()
/*      */   {
/*  400 */     _xdb_verify_unsafe_();
/*  401 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  407 */     _xdb_verify_unsafe_();
/*  408 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getSections()
/*      */   {
/*  415 */     _xdb_verify_unsafe_();
/*  416 */     return Logs.logMap(new LogKey(this, "sections"), this.sections);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getSectionsAsData()
/*      */   {
/*  423 */     _xdb_verify_unsafe_();
/*      */     
/*  425 */     PlantTreeInfo _o_ = this;
/*  426 */     Map<Integer, Integer> sections = new HashMap();
/*  427 */     for (Map.Entry<Integer, Integer> _e_ : _o_.sections.entrySet())
/*  428 */       sections.put(_e_.getKey(), _e_.getValue());
/*  429 */     return sections;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCurrent_section_id()
/*      */   {
/*  436 */     _xdb_verify_unsafe_();
/*  437 */     return this.current_section_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getSpecial_state_index()
/*      */   {
/*  444 */     _xdb_verify_unsafe_();
/*  445 */     return this.special_state_index;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<xbean.PlantTreeLog> getLogs()
/*      */   {
/*  452 */     _xdb_verify_unsafe_();
/*  453 */     return Logs.logList(new LogKey(this, "logs"), this.logs);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<xbean.PlantTreeLog> getLogsAsData()
/*      */   {
/*  459 */     _xdb_verify_unsafe_();
/*      */     
/*  461 */     PlantTreeInfo _o_ = this;
/*  462 */     List<xbean.PlantTreeLog> logs = new LinkedList();
/*  463 */     for (xbean.PlantTreeLog _v_ : _o_.logs)
/*  464 */       logs.add(new PlantTreeLog.Data(_v_));
/*  465 */     return logs;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getSpecial_state_refresh_sessionid()
/*      */   {
/*  472 */     _xdb_verify_unsafe_();
/*  473 */     return this.special_state_refresh_sessionid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Integer> getAward_section_ids()
/*      */   {
/*  480 */     _xdb_verify_unsafe_();
/*  481 */     return Logs.logSet(new LogKey(this, "award_section_ids"), this.award_section_ids);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Integer> getAward_section_idsAsData()
/*      */   {
/*  487 */     _xdb_verify_unsafe_();
/*      */     
/*  489 */     PlantTreeInfo _o_ = this;
/*  490 */     Set<Integer> award_section_ids = new SetX();
/*  491 */     award_section_ids.addAll(_o_.award_section_ids);
/*  492 */     return award_section_ids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getHas_get_activity_complete_award()
/*      */   {
/*  499 */     _xdb_verify_unsafe_();
/*  500 */     return this.has_get_activity_complete_award;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getAdd_point_times()
/*      */   {
/*  507 */     _xdb_verify_unsafe_();
/*  508 */     return this.add_point_times;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getRemove_special_state_award_times()
/*      */   {
/*  515 */     _xdb_verify_unsafe_();
/*  516 */     return this.remove_special_state_award_times;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getOnline_reward_point()
/*      */   {
/*  523 */     _xdb_verify_unsafe_();
/*  524 */     return this.online_reward_point;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getOnline_reward_point_timestamp()
/*      */   {
/*  531 */     _xdb_verify_unsafe_();
/*  532 */     return this.online_reward_point_timestamp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCurrent_section_id(int _v_)
/*      */   {
/*  539 */     _xdb_verify_unsafe_();
/*  540 */     Logs.logIf(new LogKey(this, "current_section_id")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  544 */         new LogInt(this, PlantTreeInfo.this.current_section_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  548 */             PlantTreeInfo.this.current_section_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  552 */     });
/*  553 */     this.current_section_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSpecial_state_index(int _v_)
/*      */   {
/*  560 */     _xdb_verify_unsafe_();
/*  561 */     Logs.logIf(new LogKey(this, "special_state_index")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  565 */         new LogInt(this, PlantTreeInfo.this.special_state_index)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  569 */             PlantTreeInfo.this.special_state_index = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  573 */     });
/*  574 */     this.special_state_index = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSpecial_state_refresh_sessionid(long _v_)
/*      */   {
/*  581 */     _xdb_verify_unsafe_();
/*  582 */     Logs.logIf(new LogKey(this, "special_state_refresh_sessionid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  586 */         new xdb.logs.LogLong(this, PlantTreeInfo.this.special_state_refresh_sessionid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  590 */             PlantTreeInfo.this.special_state_refresh_sessionid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  594 */     });
/*  595 */     this.special_state_refresh_sessionid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setHas_get_activity_complete_award(boolean _v_)
/*      */   {
/*  602 */     _xdb_verify_unsafe_();
/*  603 */     Logs.logIf(new LogKey(this, "has_get_activity_complete_award")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  607 */         new xdb.logs.LogObject(this, Boolean.valueOf(PlantTreeInfo.this.has_get_activity_complete_award))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  611 */             PlantTreeInfo.this.has_get_activity_complete_award = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  615 */     });
/*  616 */     this.has_get_activity_complete_award = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAdd_point_times(int _v_)
/*      */   {
/*  623 */     _xdb_verify_unsafe_();
/*  624 */     Logs.logIf(new LogKey(this, "add_point_times")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  628 */         new LogInt(this, PlantTreeInfo.this.add_point_times)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  632 */             PlantTreeInfo.this.add_point_times = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  636 */     });
/*  637 */     this.add_point_times = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRemove_special_state_award_times(int _v_)
/*      */   {
/*  644 */     _xdb_verify_unsafe_();
/*  645 */     Logs.logIf(new LogKey(this, "remove_special_state_award_times")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  649 */         new LogInt(this, PlantTreeInfo.this.remove_special_state_award_times)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  653 */             PlantTreeInfo.this.remove_special_state_award_times = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  657 */     });
/*  658 */     this.remove_special_state_award_times = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setOnline_reward_point(int _v_)
/*      */   {
/*  665 */     _xdb_verify_unsafe_();
/*  666 */     Logs.logIf(new LogKey(this, "online_reward_point")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  670 */         new LogInt(this, PlantTreeInfo.this.online_reward_point)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  674 */             PlantTreeInfo.this.online_reward_point = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  678 */     });
/*  679 */     this.online_reward_point = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setOnline_reward_point_timestamp(long _v_)
/*      */   {
/*  686 */     _xdb_verify_unsafe_();
/*  687 */     Logs.logIf(new LogKey(this, "online_reward_point_timestamp")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  691 */         new xdb.logs.LogLong(this, PlantTreeInfo.this.online_reward_point_timestamp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  695 */             PlantTreeInfo.this.online_reward_point_timestamp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  699 */     });
/*  700 */     this.online_reward_point_timestamp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  706 */     _xdb_verify_unsafe_();
/*  707 */     PlantTreeInfo _o_ = null;
/*  708 */     if ((_o1_ instanceof PlantTreeInfo)) { _o_ = (PlantTreeInfo)_o1_;
/*  709 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  710 */       return false;
/*  711 */     if (!this.sections.equals(_o_.sections)) return false;
/*  712 */     if (this.current_section_id != _o_.current_section_id) return false;
/*  713 */     if (this.special_state_index != _o_.special_state_index) return false;
/*  714 */     if (!this.logs.equals(_o_.logs)) return false;
/*  715 */     if (this.special_state_refresh_sessionid != _o_.special_state_refresh_sessionid) return false;
/*  716 */     if (!this.award_section_ids.equals(_o_.award_section_ids)) return false;
/*  717 */     if (this.has_get_activity_complete_award != _o_.has_get_activity_complete_award) return false;
/*  718 */     if (this.add_point_times != _o_.add_point_times) return false;
/*  719 */     if (this.remove_special_state_award_times != _o_.remove_special_state_award_times) return false;
/*  720 */     if (this.online_reward_point != _o_.online_reward_point) return false;
/*  721 */     if (this.online_reward_point_timestamp != _o_.online_reward_point_timestamp) return false;
/*  722 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  728 */     _xdb_verify_unsafe_();
/*  729 */     int _h_ = 0;
/*  730 */     _h_ += this.sections.hashCode();
/*  731 */     _h_ += this.current_section_id;
/*  732 */     _h_ += this.special_state_index;
/*  733 */     _h_ += this.logs.hashCode();
/*  734 */     _h_ = (int)(_h_ + this.special_state_refresh_sessionid);
/*  735 */     _h_ += this.award_section_ids.hashCode();
/*  736 */     _h_ += (this.has_get_activity_complete_award ? 1231 : 1237);
/*  737 */     _h_ += this.add_point_times;
/*  738 */     _h_ += this.remove_special_state_award_times;
/*  739 */     _h_ += this.online_reward_point;
/*  740 */     _h_ = (int)(_h_ + this.online_reward_point_timestamp);
/*  741 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  747 */     _xdb_verify_unsafe_();
/*  748 */     StringBuilder _sb_ = new StringBuilder();
/*  749 */     _sb_.append("(");
/*  750 */     _sb_.append(this.sections);
/*  751 */     _sb_.append(",");
/*  752 */     _sb_.append(this.current_section_id);
/*  753 */     _sb_.append(",");
/*  754 */     _sb_.append(this.special_state_index);
/*  755 */     _sb_.append(",");
/*  756 */     _sb_.append(this.logs);
/*  757 */     _sb_.append(",");
/*  758 */     _sb_.append(this.special_state_refresh_sessionid);
/*  759 */     _sb_.append(",");
/*  760 */     _sb_.append(this.award_section_ids);
/*  761 */     _sb_.append(",");
/*  762 */     _sb_.append(this.has_get_activity_complete_award);
/*  763 */     _sb_.append(",");
/*  764 */     _sb_.append(this.add_point_times);
/*  765 */     _sb_.append(",");
/*  766 */     _sb_.append(this.remove_special_state_award_times);
/*  767 */     _sb_.append(",");
/*  768 */     _sb_.append(this.online_reward_point);
/*  769 */     _sb_.append(",");
/*  770 */     _sb_.append(this.online_reward_point_timestamp);
/*  771 */     _sb_.append(")");
/*  772 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  778 */     ListenableBean lb = new ListenableBean();
/*  779 */     lb.add(new xdb.logs.ListenableMap().setVarName("sections"));
/*  780 */     lb.add(new ListenableChanged().setVarName("current_section_id"));
/*  781 */     lb.add(new ListenableChanged().setVarName("special_state_index"));
/*  782 */     lb.add(new ListenableChanged().setVarName("logs"));
/*  783 */     lb.add(new ListenableChanged().setVarName("special_state_refresh_sessionid"));
/*  784 */     lb.add(new xdb.logs.ListenableSet().setVarName("award_section_ids"));
/*  785 */     lb.add(new ListenableChanged().setVarName("has_get_activity_complete_award"));
/*  786 */     lb.add(new ListenableChanged().setVarName("add_point_times"));
/*  787 */     lb.add(new ListenableChanged().setVarName("remove_special_state_award_times"));
/*  788 */     lb.add(new ListenableChanged().setVarName("online_reward_point"));
/*  789 */     lb.add(new ListenableChanged().setVarName("online_reward_point_timestamp"));
/*  790 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.PlantTreeInfo {
/*      */     private Const() {}
/*      */     
/*      */     PlantTreeInfo nThis() {
/*  797 */       return PlantTreeInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  803 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PlantTreeInfo copy()
/*      */     {
/*  809 */       return PlantTreeInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PlantTreeInfo toData()
/*      */     {
/*  815 */       return PlantTreeInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.PlantTreeInfo toBean()
/*      */     {
/*  820 */       return PlantTreeInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PlantTreeInfo toDataIf()
/*      */     {
/*  826 */       return PlantTreeInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.PlantTreeInfo toBeanIf()
/*      */     {
/*  831 */       return PlantTreeInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getSections()
/*      */     {
/*  838 */       PlantTreeInfo.this._xdb_verify_unsafe_();
/*  839 */       return xdb.Consts.constMap(PlantTreeInfo.this.sections);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getSectionsAsData()
/*      */     {
/*  846 */       PlantTreeInfo.this._xdb_verify_unsafe_();
/*      */       
/*  848 */       PlantTreeInfo _o_ = PlantTreeInfo.this;
/*  849 */       Map<Integer, Integer> sections = new HashMap();
/*  850 */       for (Map.Entry<Integer, Integer> _e_ : _o_.sections.entrySet())
/*  851 */         sections.put(_e_.getKey(), _e_.getValue());
/*  852 */       return sections;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrent_section_id()
/*      */     {
/*  859 */       PlantTreeInfo.this._xdb_verify_unsafe_();
/*  860 */       return PlantTreeInfo.this.current_section_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getSpecial_state_index()
/*      */     {
/*  867 */       PlantTreeInfo.this._xdb_verify_unsafe_();
/*  868 */       return PlantTreeInfo.this.special_state_index;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.PlantTreeLog> getLogs()
/*      */     {
/*  875 */       PlantTreeInfo.this._xdb_verify_unsafe_();
/*  876 */       return xdb.Consts.constList(PlantTreeInfo.this.logs);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<xbean.PlantTreeLog> getLogsAsData()
/*      */     {
/*  882 */       PlantTreeInfo.this._xdb_verify_unsafe_();
/*      */       
/*  884 */       PlantTreeInfo _o_ = PlantTreeInfo.this;
/*  885 */       List<xbean.PlantTreeLog> logs = new LinkedList();
/*  886 */       for (xbean.PlantTreeLog _v_ : _o_.logs)
/*  887 */         logs.add(new PlantTreeLog.Data(_v_));
/*  888 */       return logs;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSpecial_state_refresh_sessionid()
/*      */     {
/*  895 */       PlantTreeInfo.this._xdb_verify_unsafe_();
/*  896 */       return PlantTreeInfo.this.special_state_refresh_sessionid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getAward_section_ids()
/*      */     {
/*  903 */       PlantTreeInfo.this._xdb_verify_unsafe_();
/*  904 */       return xdb.Consts.constSet(PlantTreeInfo.this.award_section_ids);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Integer> getAward_section_idsAsData()
/*      */     {
/*  910 */       PlantTreeInfo.this._xdb_verify_unsafe_();
/*      */       
/*  912 */       PlantTreeInfo _o_ = PlantTreeInfo.this;
/*  913 */       Set<Integer> award_section_ids = new SetX();
/*  914 */       award_section_ids.addAll(_o_.award_section_ids);
/*  915 */       return award_section_ids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getHas_get_activity_complete_award()
/*      */     {
/*  922 */       PlantTreeInfo.this._xdb_verify_unsafe_();
/*  923 */       return PlantTreeInfo.this.has_get_activity_complete_award;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAdd_point_times()
/*      */     {
/*  930 */       PlantTreeInfo.this._xdb_verify_unsafe_();
/*  931 */       return PlantTreeInfo.this.add_point_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRemove_special_state_award_times()
/*      */     {
/*  938 */       PlantTreeInfo.this._xdb_verify_unsafe_();
/*  939 */       return PlantTreeInfo.this.remove_special_state_award_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getOnline_reward_point()
/*      */     {
/*  946 */       PlantTreeInfo.this._xdb_verify_unsafe_();
/*  947 */       return PlantTreeInfo.this.online_reward_point;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getOnline_reward_point_timestamp()
/*      */     {
/*  954 */       PlantTreeInfo.this._xdb_verify_unsafe_();
/*  955 */       return PlantTreeInfo.this.online_reward_point_timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_section_id(int _v_)
/*      */     {
/*  962 */       PlantTreeInfo.this._xdb_verify_unsafe_();
/*  963 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSpecial_state_index(int _v_)
/*      */     {
/*  970 */       PlantTreeInfo.this._xdb_verify_unsafe_();
/*  971 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSpecial_state_refresh_sessionid(long _v_)
/*      */     {
/*  978 */       PlantTreeInfo.this._xdb_verify_unsafe_();
/*  979 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHas_get_activity_complete_award(boolean _v_)
/*      */     {
/*  986 */       PlantTreeInfo.this._xdb_verify_unsafe_();
/*  987 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAdd_point_times(int _v_)
/*      */     {
/*  994 */       PlantTreeInfo.this._xdb_verify_unsafe_();
/*  995 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRemove_special_state_award_times(int _v_)
/*      */     {
/* 1002 */       PlantTreeInfo.this._xdb_verify_unsafe_();
/* 1003 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOnline_reward_point(int _v_)
/*      */     {
/* 1010 */       PlantTreeInfo.this._xdb_verify_unsafe_();
/* 1011 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOnline_reward_point_timestamp(long _v_)
/*      */     {
/* 1018 */       PlantTreeInfo.this._xdb_verify_unsafe_();
/* 1019 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/* 1025 */       PlantTreeInfo.this._xdb_verify_unsafe_();
/* 1026 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/* 1032 */       PlantTreeInfo.this._xdb_verify_unsafe_();
/* 1033 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/* 1039 */       return PlantTreeInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1045 */       return PlantTreeInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1051 */       PlantTreeInfo.this._xdb_verify_unsafe_();
/* 1052 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/* 1058 */       return PlantTreeInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1064 */       return PlantTreeInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1070 */       PlantTreeInfo.this._xdb_verify_unsafe_();
/* 1071 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/* 1077 */       return PlantTreeInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1083 */       return PlantTreeInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/* 1089 */       return PlantTreeInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/* 1095 */       return PlantTreeInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/* 1101 */       return PlantTreeInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/* 1107 */       return PlantTreeInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1113 */       return PlantTreeInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.PlantTreeInfo
/*      */   {
/*      */     private HashMap<Integer, Integer> sections;
/*      */     
/*      */     private int current_section_id;
/*      */     
/*      */     private int special_state_index;
/*      */     
/*      */     private LinkedList<xbean.PlantTreeLog> logs;
/*      */     
/*      */     private long special_state_refresh_sessionid;
/*      */     
/*      */     private HashSet<Integer> award_section_ids;
/*      */     
/*      */     private boolean has_get_activity_complete_award;
/*      */     
/*      */     private int add_point_times;
/*      */     
/*      */     private int remove_special_state_award_times;
/*      */     
/*      */     private int online_reward_point;
/*      */     
/*      */     private long online_reward_point_timestamp;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1145 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 1150 */       this.sections = new HashMap();
/* 1151 */       this.current_section_id = 1;
/* 1152 */       this.special_state_index = 0;
/* 1153 */       this.logs = new LinkedList();
/* 1154 */       this.special_state_refresh_sessionid = -1L;
/* 1155 */       this.award_section_ids = new HashSet();
/* 1156 */       this.has_get_activity_complete_award = false;
/* 1157 */       this.add_point_times = 0;
/* 1158 */       this.remove_special_state_award_times = 0;
/* 1159 */       this.online_reward_point = 0;
/* 1160 */       this.online_reward_point_timestamp = -1L;
/*      */     }
/*      */     
/*      */     Data(xbean.PlantTreeInfo _o1_)
/*      */     {
/* 1165 */       if ((_o1_ instanceof PlantTreeInfo)) { assign((PlantTreeInfo)_o1_);
/* 1166 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 1167 */       } else if ((_o1_ instanceof PlantTreeInfo.Const)) assign(((PlantTreeInfo.Const)_o1_).nThis()); else {
/* 1168 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(PlantTreeInfo _o_) {
/* 1173 */       this.sections = new HashMap();
/* 1174 */       for (Map.Entry<Integer, Integer> _e_ : _o_.sections.entrySet())
/* 1175 */         this.sections.put(_e_.getKey(), _e_.getValue());
/* 1176 */       this.current_section_id = _o_.current_section_id;
/* 1177 */       this.special_state_index = _o_.special_state_index;
/* 1178 */       this.logs = new LinkedList();
/* 1179 */       for (xbean.PlantTreeLog _v_ : _o_.logs)
/* 1180 */         this.logs.add(new PlantTreeLog.Data(_v_));
/* 1181 */       this.special_state_refresh_sessionid = _o_.special_state_refresh_sessionid;
/* 1182 */       this.award_section_ids = new HashSet();
/* 1183 */       this.award_section_ids.addAll(_o_.award_section_ids);
/* 1184 */       this.has_get_activity_complete_award = _o_.has_get_activity_complete_award;
/* 1185 */       this.add_point_times = _o_.add_point_times;
/* 1186 */       this.remove_special_state_award_times = _o_.remove_special_state_award_times;
/* 1187 */       this.online_reward_point = _o_.online_reward_point;
/* 1188 */       this.online_reward_point_timestamp = _o_.online_reward_point_timestamp;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/* 1193 */       this.sections = new HashMap();
/* 1194 */       for (Map.Entry<Integer, Integer> _e_ : _o_.sections.entrySet())
/* 1195 */         this.sections.put(_e_.getKey(), _e_.getValue());
/* 1196 */       this.current_section_id = _o_.current_section_id;
/* 1197 */       this.special_state_index = _o_.special_state_index;
/* 1198 */       this.logs = new LinkedList();
/* 1199 */       for (xbean.PlantTreeLog _v_ : _o_.logs)
/* 1200 */         this.logs.add(new PlantTreeLog.Data(_v_));
/* 1201 */       this.special_state_refresh_sessionid = _o_.special_state_refresh_sessionid;
/* 1202 */       this.award_section_ids = new HashSet();
/* 1203 */       this.award_section_ids.addAll(_o_.award_section_ids);
/* 1204 */       this.has_get_activity_complete_award = _o_.has_get_activity_complete_award;
/* 1205 */       this.add_point_times = _o_.add_point_times;
/* 1206 */       this.remove_special_state_award_times = _o_.remove_special_state_award_times;
/* 1207 */       this.online_reward_point = _o_.online_reward_point;
/* 1208 */       this.online_reward_point_timestamp = _o_.online_reward_point_timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1214 */       _os_.compact_uint32(this.sections.size());
/* 1215 */       for (Map.Entry<Integer, Integer> _e_ : this.sections.entrySet())
/*      */       {
/* 1217 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 1218 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/* 1220 */       _os_.marshal(this.current_section_id);
/* 1221 */       _os_.marshal(this.special_state_index);
/* 1222 */       _os_.compact_uint32(this.logs.size());
/* 1223 */       for (xbean.PlantTreeLog _v_ : this.logs)
/*      */       {
/* 1225 */         _v_.marshal(_os_);
/*      */       }
/* 1227 */       _os_.marshal(this.special_state_refresh_sessionid);
/* 1228 */       _os_.compact_uint32(this.award_section_ids.size());
/* 1229 */       for (Integer _v_ : this.award_section_ids)
/*      */       {
/* 1231 */         _os_.marshal(_v_.intValue());
/*      */       }
/* 1233 */       _os_.marshal(this.has_get_activity_complete_award);
/* 1234 */       _os_.marshal(this.add_point_times);
/* 1235 */       _os_.marshal(this.remove_special_state_award_times);
/* 1236 */       _os_.marshal(this.online_reward_point);
/* 1237 */       _os_.marshal(this.online_reward_point_timestamp);
/* 1238 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1245 */       int size = _os_.uncompact_uint32();
/* 1246 */       if (size >= 12)
/*      */       {
/* 1248 */         this.sections = new HashMap(size * 2);
/*      */       }
/* 1250 */       for (; size > 0; size--)
/*      */       {
/* 1252 */         int _k_ = 0;
/* 1253 */         _k_ = _os_.unmarshal_int();
/* 1254 */         int _v_ = 0;
/* 1255 */         _v_ = _os_.unmarshal_int();
/* 1256 */         this.sections.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/* 1259 */       this.current_section_id = _os_.unmarshal_int();
/* 1260 */       this.special_state_index = _os_.unmarshal_int();
/* 1261 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1263 */         xbean.PlantTreeLog _v_ = xbean.Pod.newPlantTreeLogData();
/* 1264 */         _v_.unmarshal(_os_);
/* 1265 */         this.logs.add(_v_);
/*      */       }
/* 1267 */       this.special_state_refresh_sessionid = _os_.unmarshal_long();
/* 1268 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1270 */         int _v_ = 0;
/* 1271 */         _v_ = _os_.unmarshal_int();
/* 1272 */         this.award_section_ids.add(Integer.valueOf(_v_));
/*      */       }
/* 1274 */       this.has_get_activity_complete_award = _os_.unmarshal_boolean();
/* 1275 */       this.add_point_times = _os_.unmarshal_int();
/* 1276 */       this.remove_special_state_award_times = _os_.unmarshal_int();
/* 1277 */       this.online_reward_point = _os_.unmarshal_int();
/* 1278 */       this.online_reward_point_timestamp = _os_.unmarshal_long();
/* 1279 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1285 */       int _size_ = 0;
/* 1286 */       for (Map.Entry<Integer, Integer> _e_ : this.sections.entrySet())
/*      */       {
/* 1288 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 1289 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 1291 */       _size_ += CodedOutputStream.computeInt32Size(2, this.current_section_id);
/* 1292 */       _size_ += CodedOutputStream.computeInt32Size(3, this.special_state_index);
/* 1293 */       for (xbean.PlantTreeLog _v_ : this.logs)
/*      */       {
/* 1295 */         _size_ += CodedOutputStream.computeMessageSize(4, _v_);
/*      */       }
/* 1297 */       _size_ += CodedOutputStream.computeInt64Size(5, this.special_state_refresh_sessionid);
/* 1298 */       for (Integer _v_ : this.award_section_ids)
/*      */       {
/* 1300 */         _size_ += CodedOutputStream.computeInt32Size(6, _v_.intValue());
/*      */       }
/* 1302 */       _size_ += CodedOutputStream.computeBoolSize(7, this.has_get_activity_complete_award);
/* 1303 */       _size_ += CodedOutputStream.computeInt32Size(8, this.add_point_times);
/* 1304 */       _size_ += CodedOutputStream.computeInt32Size(9, this.remove_special_state_award_times);
/* 1305 */       _size_ += CodedOutputStream.computeInt32Size(10, this.online_reward_point);
/* 1306 */       _size_ += CodedOutputStream.computeInt64Size(11, this.online_reward_point_timestamp);
/* 1307 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1315 */         for (Map.Entry<Integer, Integer> _e_ : this.sections.entrySet())
/*      */         {
/* 1317 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 1318 */           _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*      */         }
/* 1320 */         _output_.writeInt32(2, this.current_section_id);
/* 1321 */         _output_.writeInt32(3, this.special_state_index);
/* 1322 */         for (xbean.PlantTreeLog _v_ : this.logs)
/*      */         {
/* 1324 */           _output_.writeMessage(4, _v_);
/*      */         }
/* 1326 */         _output_.writeInt64(5, this.special_state_refresh_sessionid);
/* 1327 */         for (Integer _v_ : this.award_section_ids)
/*      */         {
/* 1329 */           _output_.writeInt32(6, _v_.intValue());
/*      */         }
/* 1331 */         _output_.writeBool(7, this.has_get_activity_complete_award);
/* 1332 */         _output_.writeInt32(8, this.add_point_times);
/* 1333 */         _output_.writeInt32(9, this.remove_special_state_award_times);
/* 1334 */         _output_.writeInt32(10, this.online_reward_point);
/* 1335 */         _output_.writeInt64(11, this.online_reward_point_timestamp);
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/* 1339 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1341 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1349 */         boolean done = false;
/* 1350 */         while (!done)
/*      */         {
/* 1352 */           int tag = _input_.readTag();
/* 1353 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1357 */             done = true;
/* 1358 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1362 */             int _k_ = 0;
/* 1363 */             _k_ = _input_.readInt32();
/* 1364 */             int readTag = _input_.readTag();
/* 1365 */             if (8 != readTag)
/*      */             {
/* 1367 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1369 */             int _v_ = 0;
/* 1370 */             _v_ = _input_.readInt32();
/* 1371 */             this.sections.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 1372 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1376 */             this.current_section_id = _input_.readInt32();
/* 1377 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1381 */             this.special_state_index = _input_.readInt32();
/* 1382 */             break;
/*      */           
/*      */ 
/*      */           case 34: 
/* 1386 */             xbean.PlantTreeLog _v_ = xbean.Pod.newPlantTreeLogData();
/* 1387 */             _input_.readMessage(_v_);
/* 1388 */             this.logs.add(_v_);
/* 1389 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1393 */             this.special_state_refresh_sessionid = _input_.readInt64();
/* 1394 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1398 */             int _v_ = 0;
/* 1399 */             _v_ = _input_.readInt32();
/* 1400 */             this.award_section_ids.add(Integer.valueOf(_v_));
/* 1401 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1405 */             this.has_get_activity_complete_award = _input_.readBool();
/* 1406 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1410 */             this.add_point_times = _input_.readInt32();
/* 1411 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 1415 */             this.remove_special_state_award_times = _input_.readInt32();
/* 1416 */             break;
/*      */           
/*      */ 
/*      */           case 80: 
/* 1420 */             this.online_reward_point = _input_.readInt32();
/* 1421 */             break;
/*      */           
/*      */ 
/*      */           case 88: 
/* 1425 */             this.online_reward_point_timestamp = _input_.readInt64();
/* 1426 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1430 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1432 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1441 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/* 1445 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1447 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PlantTreeInfo copy()
/*      */     {
/* 1453 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PlantTreeInfo toData()
/*      */     {
/* 1459 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.PlantTreeInfo toBean()
/*      */     {
/* 1464 */       return new PlantTreeInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PlantTreeInfo toDataIf()
/*      */     {
/* 1470 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.PlantTreeInfo toBeanIf()
/*      */     {
/* 1475 */       return new PlantTreeInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1481 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1485 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1489 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1493 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1497 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1501 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1505 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getSections()
/*      */     {
/* 1512 */       return this.sections;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getSectionsAsData()
/*      */     {
/* 1519 */       return this.sections;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrent_section_id()
/*      */     {
/* 1526 */       return this.current_section_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getSpecial_state_index()
/*      */     {
/* 1533 */       return this.special_state_index;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.PlantTreeLog> getLogs()
/*      */     {
/* 1540 */       return this.logs;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.PlantTreeLog> getLogsAsData()
/*      */     {
/* 1547 */       return this.logs;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSpecial_state_refresh_sessionid()
/*      */     {
/* 1554 */       return this.special_state_refresh_sessionid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getAward_section_ids()
/*      */     {
/* 1561 */       return this.award_section_ids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getAward_section_idsAsData()
/*      */     {
/* 1568 */       return this.award_section_ids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getHas_get_activity_complete_award()
/*      */     {
/* 1575 */       return this.has_get_activity_complete_award;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAdd_point_times()
/*      */     {
/* 1582 */       return this.add_point_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRemove_special_state_award_times()
/*      */     {
/* 1589 */       return this.remove_special_state_award_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getOnline_reward_point()
/*      */     {
/* 1596 */       return this.online_reward_point;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getOnline_reward_point_timestamp()
/*      */     {
/* 1603 */       return this.online_reward_point_timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_section_id(int _v_)
/*      */     {
/* 1610 */       this.current_section_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSpecial_state_index(int _v_)
/*      */     {
/* 1617 */       this.special_state_index = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSpecial_state_refresh_sessionid(long _v_)
/*      */     {
/* 1624 */       this.special_state_refresh_sessionid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHas_get_activity_complete_award(boolean _v_)
/*      */     {
/* 1631 */       this.has_get_activity_complete_award = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAdd_point_times(int _v_)
/*      */     {
/* 1638 */       this.add_point_times = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRemove_special_state_award_times(int _v_)
/*      */     {
/* 1645 */       this.remove_special_state_award_times = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOnline_reward_point(int _v_)
/*      */     {
/* 1652 */       this.online_reward_point = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOnline_reward_point_timestamp(long _v_)
/*      */     {
/* 1659 */       this.online_reward_point_timestamp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1665 */       if (!(_o1_ instanceof Data)) return false;
/* 1666 */       Data _o_ = (Data)_o1_;
/* 1667 */       if (!this.sections.equals(_o_.sections)) return false;
/* 1668 */       if (this.current_section_id != _o_.current_section_id) return false;
/* 1669 */       if (this.special_state_index != _o_.special_state_index) return false;
/* 1670 */       if (!this.logs.equals(_o_.logs)) return false;
/* 1671 */       if (this.special_state_refresh_sessionid != _o_.special_state_refresh_sessionid) return false;
/* 1672 */       if (!this.award_section_ids.equals(_o_.award_section_ids)) return false;
/* 1673 */       if (this.has_get_activity_complete_award != _o_.has_get_activity_complete_award) return false;
/* 1674 */       if (this.add_point_times != _o_.add_point_times) return false;
/* 1675 */       if (this.remove_special_state_award_times != _o_.remove_special_state_award_times) return false;
/* 1676 */       if (this.online_reward_point != _o_.online_reward_point) return false;
/* 1677 */       if (this.online_reward_point_timestamp != _o_.online_reward_point_timestamp) return false;
/* 1678 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1684 */       int _h_ = 0;
/* 1685 */       _h_ += this.sections.hashCode();
/* 1686 */       _h_ += this.current_section_id;
/* 1687 */       _h_ += this.special_state_index;
/* 1688 */       _h_ += this.logs.hashCode();
/* 1689 */       _h_ = (int)(_h_ + this.special_state_refresh_sessionid);
/* 1690 */       _h_ += this.award_section_ids.hashCode();
/* 1691 */       _h_ += (this.has_get_activity_complete_award ? 1231 : 1237);
/* 1692 */       _h_ += this.add_point_times;
/* 1693 */       _h_ += this.remove_special_state_award_times;
/* 1694 */       _h_ += this.online_reward_point;
/* 1695 */       _h_ = (int)(_h_ + this.online_reward_point_timestamp);
/* 1696 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1702 */       StringBuilder _sb_ = new StringBuilder();
/* 1703 */       _sb_.append("(");
/* 1704 */       _sb_.append(this.sections);
/* 1705 */       _sb_.append(",");
/* 1706 */       _sb_.append(this.current_section_id);
/* 1707 */       _sb_.append(",");
/* 1708 */       _sb_.append(this.special_state_index);
/* 1709 */       _sb_.append(",");
/* 1710 */       _sb_.append(this.logs);
/* 1711 */       _sb_.append(",");
/* 1712 */       _sb_.append(this.special_state_refresh_sessionid);
/* 1713 */       _sb_.append(",");
/* 1714 */       _sb_.append(this.award_section_ids);
/* 1715 */       _sb_.append(",");
/* 1716 */       _sb_.append(this.has_get_activity_complete_award);
/* 1717 */       _sb_.append(",");
/* 1718 */       _sb_.append(this.add_point_times);
/* 1719 */       _sb_.append(",");
/* 1720 */       _sb_.append(this.remove_special_state_award_times);
/* 1721 */       _sb_.append(",");
/* 1722 */       _sb_.append(this.online_reward_point);
/* 1723 */       _sb_.append(",");
/* 1724 */       _sb_.append(this.online_reward_point_timestamp);
/* 1725 */       _sb_.append(")");
/* 1726 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\PlantTreeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */